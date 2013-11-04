function validarInclusaoAlteracao(form) {
	var objCargo = document.getElementById(form.name + ":txtCargo");
	var objSalario = document.getElementById(form.name + ":txtSalario");
	var objSituacao = document.getElementsByName(form.name + ":rdoSituacao");

	if (objCargo != null && !objCargo.disabled && isEmpty(objCargo.value)) {
		alert('Cargo obrigatório.');
		objCargo.focus();
		return false;
	}

	if (objSalario != null && !objSalario.disabled && isEmpty(objSalario.value)) {
		alert('Salário obrigatório.');
		objSalario.focus();
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