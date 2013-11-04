function validarInclusaoAlteracao(form) {
	var objDescricao = document.getElementById(form.name + ":txtTipoContato");
	var objSituacao = document.getElementsByName(form.name + ":rdoSituacao");

	if (objDescricao != null && !objDescricao.disabled && isEmpty(objDescricao.value)) {
		alert('Tipo de Contato obrigat�rio.');
		objDescricao.focus();
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
			alert('Situa��o obrigat�rio.');
			return false;
		}
	}

	return true;
}