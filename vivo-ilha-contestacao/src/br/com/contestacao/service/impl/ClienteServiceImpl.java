package br.com.contestacao.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.contestacao.controller.cadastros.model.CadastroCliente;
import br.com.contestacao.model.Cliente;
import br.com.contestacao.model.Contrato;
import br.com.contestacao.model.ContratoServico;
import br.com.contestacao.model.Servico;
import br.com.contestacao.model.SubServico;
import br.com.contestacao.model.Tarifa;
import br.com.contestacao.model.TipoTarifa;
import br.com.contestacao.model.TipoTarifaEnum;
import br.com.contestacao.model.Uf;
import br.com.contestacao.persistence.dao.ClienteDao;
import br.com.contestacao.persistence.dao.ContratoDao;
import br.com.contestacao.persistence.dao.ContratoServicoDao;
import br.com.contestacao.persistence.dao.TarifaDao;
import br.com.contestacao.service.ClienteService;

@Stateless
public class ClienteServiceImpl implements ClienteService {

	private static final long serialVersionUID = -7892857603305502905L;

	@Inject
	private ClienteDao clienteDao = null;

	@Inject
	private ContratoDao contratoDao = null;

	@Inject
	private TarifaDao tarifaDao = null;

	@Inject
	private ContratoServicoDao contratoServicoDao = null; 

	@Override
	public void salvar(CadastroCliente cadastroCliente) {
		if (cadastroCliente.isNovo()) {
			incluir(cadastroCliente);
		} else {
			alterar(cadastroCliente);
		}
	}

	private void incluir(CadastroCliente cadastroCliente) {
		Cliente cliente = atribuirCliente(cadastroCliente, new Cliente());
		cliente = clienteDao.save(cliente);

		Contrato contrato = new Contrato();
		contrato.setCliente(cliente);
		contrato = atribuirContrato(cadastroCliente, contrato);
		contrato = contratoDao.save(contrato);

		ContratoServico contratoServico = criarContratoServico(cadastroCliente, contrato);
		contratoServicoDao.save(contratoServico);

		List<Tarifa> tarifas = criarTarifas(cadastroCliente, contrato);
		for (Tarifa t : tarifas) {
			tarifaDao.save(t);
		}		
	}

	private void alterar(CadastroCliente cadastroCliente) {
		Contrato contrato = contratoDao.findById(cadastroCliente.getIdContrato());

		Cliente cliente = atribuirCliente(cadastroCliente, contrato.getCliente());
		cliente = clienteDao.save(cliente);

		contrato = atribuirContrato(cadastroCliente, contrato);
		contratoDao.save(contrato);

		List<ContratoServico> contratosServicos = contratoServicoDao.findByContrato(contrato.getId());
		for (ContratoServico cs : contratosServicos) {
			contratoServicoDao.remove(cs);
		}
		ContratoServico contratoServico = criarContratoServico(cadastroCliente, contrato);
		contratoServicoDao.save(contratoServico);

		List<Tarifa> tarifasContrato = tarifaDao.findByContrato(contrato.getId());
		for (Tarifa t : tarifasContrato) {
			tarifaDao.remove(t);
		}
		List<Tarifa> tarifas = criarTarifas(cadastroCliente, contrato);
		for (Tarifa t : tarifas) {
			tarifaDao.save(t);
		}
	}

	private Cliente atribuirCliente(CadastroCliente cadastroCliente, Cliente cliente) {
		cliente.setCnpj(cadastroCliente.getCnpj());
		cliente.setNome(cadastroCliente.getNome());

		Uf uf = new Uf();
		uf.setId(cadastroCliente.getUf());
		cliente.setUf(uf);

		return cliente;
	}

	private Contrato atribuirContrato(CadastroCliente cadastroCliente, Contrato contrato) {
		contrato.setChave(cadastroCliente.getContrato());
		contrato.setDescricao(cadastroCliente.getContrato());

		return contrato;
	}

	private ContratoServico criarContratoServico(CadastroCliente cadastroCliente, Contrato contrato) {
		ContratoServico contratoServico = new ContratoServico();
		contratoServico.setContrato(contrato);
		
		Servico servico = new Servico();
		servico.setId(cadastroCliente.getServico());
		contratoServico.setServico(servico);

		return contratoServico;
	}

	private List<Tarifa> criarTarifas(CadastroCliente cadastroCliente, Contrato contrato) {
		List<Tarifa> tarifas = new ArrayList<Tarifa>();
		if (cadastroCliente.isServicoTelefonia()) {
			tarifas.add(criarTarifa(contrato, TipoTarifaEnum.VC1, cadastroCliente.getSubServico(), cadastroCliente.getVc1()));
			tarifas.add(criarTarifa(contrato, TipoTarifaEnum.VC2, cadastroCliente.getSubServico(), cadastroCliente.getVc2()));
			tarifas.add(criarTarifa(contrato, TipoTarifaEnum.VC3, cadastroCliente.getSubServico(), cadastroCliente.getVc3()));
		} else if (cadastroCliente.isServicoSms()) {
			tarifas.add(criarTarifa(contrato, TipoTarifaEnum.NACIONAL, cadastroCliente.getSubServico(), cadastroCliente.getNacional()));
			tarifas.add(criarTarifa(contrato, TipoTarifaEnum.INTERNACIONAL, cadastroCliente.getSubServico(),
					cadastroCliente.getInternacional()));
		}  else {
			tarifas.add(criarTarifa(contrato, TipoTarifaEnum.VALOR, cadastroCliente.getSubServico(), cadastroCliente.getValor()));
		}
		return tarifas;
	}

	private Tarifa criarTarifa(Contrato contrato, TipoTarifaEnum tipoTarifaEnum, Long subServico, BigDecimal valor) {
		Tarifa tarifa = new Tarifa();
		tarifa.setContrato(contrato);
		tarifa.setValor(valor);
		
		TipoTarifa tipoTarifa = new TipoTarifa();
		tipoTarifa.setId(tipoTarifaEnum.getCodigo());
		tarifa.setTipoTarifa(tipoTarifa);

		SubServico sub = new SubServico();
		sub.setId(subServico);
		tarifa.setSubServico(sub);

		return tarifa;
	}

	@Override
	public List<CadastroCliente> listar(CadastroCliente cliente) {
		List<Tarifa> tarifas = tarifaDao.findByServicoSubServico(cliente.getServico(), cliente.getSubServico());

		Map<Long, CadastroCliente> mapTarifaClientePorContrato = new HashMap<Long, CadastroCliente>();

		for (Tarifa t : tarifas) {
			Contrato contrato = t.getContrato();

			if (!mapTarifaClientePorContrato.containsKey(contrato.getId())) {
				CadastroCliente cadastroCliente = new CadastroCliente();

				Cliente c = contrato.getCliente();
				SubServico subServico = t.getSubServico();
				Servico servico = subServico.getServico();

				cadastroCliente.setCnpj(c.getCnpj());
				cadastroCliente.setNome(c.getNome());
				cadastroCliente.setUf(c.getUf().getId());
				cadastroCliente.setIdContrato(contrato.getId());
				cadastroCliente.setContrato(contrato.getChave());
				cadastroCliente.setServico(servico.getId());
				cadastroCliente.setNomeServico(servico.getDescricao());
				cadastroCliente.setSubServico(subServico.getId());
				cadastroCliente.setNomeSubServico(subServico.getDescricao());

				mapTarifaClientePorContrato.put(contrato.getId(), cadastroCliente);
			}
			CadastroCliente cadastroCliente = mapTarifaClientePorContrato.get(contrato.getId());

			atribuirValorTarifa(t, cadastroCliente);
		}

		return new ArrayList<CadastroCliente>(mapTarifaClientePorContrato.values());
	}

	private void atribuirValorTarifa(Tarifa t, CadastroCliente cadastroCliente) {
		TipoTarifa tipoTarifa = t.getTipoTarifa();
		if (TipoTarifaEnum.VC1.getCodigo().equals(tipoTarifa.getId())) {
			cadastroCliente.setVc1(t.getValor());
		} else if (TipoTarifaEnum.VC2.getCodigo().equals(tipoTarifa.getId())) {
			cadastroCliente.setVc2(t.getValor());
		} else if (TipoTarifaEnum.VC3.getCodigo().equals(tipoTarifa.getId())) {
			cadastroCliente.setVc3(t.getValor());
		} else if (TipoTarifaEnum.NACIONAL.getCodigo().equals(tipoTarifa.getId())) {
			cadastroCliente.setNacional(t.getValor());
		} else if (TipoTarifaEnum.INTERNACIONAL.getCodigo().equals(tipoTarifa.getId())) {
			cadastroCliente.setInternacional(t.getValor());
		} else if (TipoTarifaEnum.VALOR.getCodigo().equals(tipoTarifa.getId())) {
			cadastroCliente.setValor(t.getValor());
		}
	}

	@Override
	public List<Cliente> listar() {
		return clienteDao.findAll();
	}

	@Override
	public Cliente buscarPorCnpj(String cnpj) {
		List<Cliente> clientes = clienteDao.findByCnpj(cnpj);
		if(!clientes.isEmpty()) {
			return clientes.iterator().next();
		}

		return new Cliente();
	}
}