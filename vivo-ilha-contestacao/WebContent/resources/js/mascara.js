function carregarMascaras() {
	$(".cpf").mask("000.000.000-00");
	$(".cnpj").mask("00.000.000/0000-00");
	$(".valor").mask("000.000.000,00", {reverse: true});
}

function atualizarMascaraValor(data) {
	if (data.status == "success") {
		carregarMascaras();
	}
}