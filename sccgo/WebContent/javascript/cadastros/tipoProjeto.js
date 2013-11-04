
function validarInclusaoAlteracao(form) {
	var objNomeProjeto = document.getElementById(form.name + ":txtNomeProjeto");
	var objSituacao = document.getElementsByName(form.name + ":rdoSituacao");


	if (objNomeProjeto != null && !objNomeProjeto.disabled && isEmpty(objNomeProjeto.value)) {
		alert('Nome do Projeto obrigat�rio.');
		objNomeProjeto.focus();
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