
function validarInclusaoAlteracao(form) {
	var objDescricao = document.getElementById(form.name + ":txtDescTipoContrato");
	var objCondicao = document.getElementById(form.name + ":comboCondicaoPagamento");
	var objSituacao = document.getElementsByName(form.name + ":rdoSituacao");

	if (objDescricao != null && !objDescricao.disabled && isEmpty(objDescricao.value)) {
		alert('Tipo de Contrato obrigatório.');
		objDescricao.focus();
		return false;
	}
	
	if (objCondicao != null && !objCondicao.disabled && isEmpty(objCondicao.value)) {
		alert('Condição de Pagamento obrigatório.');
		objCondicao.focus();
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