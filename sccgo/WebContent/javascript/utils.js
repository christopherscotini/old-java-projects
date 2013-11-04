function onlyNum() {
	if (document.all) {// Internet Explorer
		var tecla = event.keyCode;
	} else if(document.layers) {// Nestcape
		var tecla = event.which;
	}
	if (tecla > 47 && tecla < 58) {// numeros de 0 a 9
		return true;
	}	else {
		event.keyCode = 0;
		return false;
	}
}

function cleanClipboard() {
	clipboardData.clearData();
}

function trim(entrada) {
 	if(entrada == null) {
 		return '';
 	}
	var expressao = '/(^\s*)|(\s*$)/g';
	return entrada.replace(expressao, "");
}

function isEmpty(entrada) {
 	return (entrada == null || trim(entrada) == '');
}

function loadMasksJQuery() {
	jQuery.mask.masks = jQuery.extend(jQuery.mask.masks,{
		decimalBr8:{ mask : '99,999.999', type : 'reverse' }
	});

	(function(jQuery){jQuery(function(){jQuery('input:text').setMask();});})(jQuery);

	var inputMasks = 'input:text[alt*="decimalBr8"]';

	jQuery.each(jQuery(inputMasks), function(i, val) {
    	val.attachEvent('onpaste', function() { return false; });
    });
}

function verificarRadioListaSelecionado(rdoName) {
	var objRadio = document.getElementsByName(rdoName);

	if (objRadio != null) {
		for (var i = 0; i < objRadio.length; i++) {
			if (objRadio[i].checked) {
				return true;
			}
		}

		alert('Selecione um registro da lista.');
		return false;
	}

	return true;
}