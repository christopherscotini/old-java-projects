function validarInclusaoAlteracao(form) {
	var objDescricao = document.getElementById(form.name + ":txtNomeCondicao");

	if (objDescricao != null && !objDescricao.disabled && isEmpty(objDescricao.value)) {
		alert('Condição de Pagamento obrigatório.');
		objDescricao.focus();
		return false;
	}

	return true;
}