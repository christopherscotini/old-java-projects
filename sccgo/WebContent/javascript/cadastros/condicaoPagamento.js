function validarInclusaoAlteracao(form) {
	var objDescricao = document.getElementById(form.name + ":txtNomeCondicao");

	if (objDescricao != null && !objDescricao.disabled && isEmpty(objDescricao.value)) {
		alert('Condi��o de Pagamento obrigat�rio.');
		objDescricao.focus();
		return false;
	}

	return true;
}