function validarInclusaoAlteracao(form) {
	var objCodigo = document.getElementById(form.name + ":txtCodigo");
	var objCargo = document.getElementById(form.name + ":txtCargo");
	var objSalario = document.getElementById(form.name + ":txtSalario");
	var objSituacao = document.getElementsByName(form.name + ":rdoSituacao");

	if (objCodigo != null && !objCodigo.disabled && isEmpty(objCodigo.value)) {
		alert('C�digo obrigat�rio.');
		objCodigo.focus();
		return false;
	}

	if (objCargo != null && !objCargo.disabled && isEmpty(objCargo.value)) {
		alert('Cargo obrigat�rio.');
		objCargo.focus();
		return false;
	}

	if (objSalario != null && !objSalario.disabled && isEmpty(objSalario.value)) {
		alert('Sal�rio obrigat�rio.');
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
			alert('Situa��o obrigat�rio.');
			return false;
		}
	}

	return true;
}