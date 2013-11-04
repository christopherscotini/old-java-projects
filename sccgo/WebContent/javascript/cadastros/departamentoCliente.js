
function validarInclusaoAlteracao(form) {
	var objCliente = document.getElementById(form.name + ":comboCliente");
	var objNomeDepartamento = document.getElementById(form.name + ":txtDepartamento");
	var objJuncao = document.getElementById(form.name + ":txtJuncao");
	var objLocal = document.getElementById(form.name + ":comboLocal");
	var objSituacao = document.getElementsByName(form.name + ":rdoSituacao");

	if (objCliente != null && !objCliente.disabled && isEmpty(objCliente.value)) {
		alert('Cliente obrigatório.');
		objCliente.focus();
		return false;
	}
	
	if (objNomeDepartamento != null && !objNomeDepartamento.disabled && isEmpty(objNomeDepartamento.value)) {
		alert('Nome do Departamento obrigatório.');
		objNomeDepartamento.focus();
		return false;
	}
	
	if (objJuncao != null && !objJuncao.disabled && isEmpty(objJuncao.value)) {
		alert('Código Junção obrigatório.');
		objJuncao.focus();
		return false;
	}
	
	if (objLocal != null && !objLocal.disabled && isEmpty(objLocal.value)) {
		alert('Local obrigatório.');
		objLocal.focus();
		return false;
	}

	if (objSituacao != null && objSituacao.length > 0) {
		var rdoSelecionado = false;
		for (var i = 0; i < objSituacao.length; i++) {
			if (objSituacao[i].checked) {
				rdoSelecionado = true;
			}
		}

		if (!rdoSelecionado) {
			alert('Situação obrigatório.');
			return false;
		}
	}

	return true;
}