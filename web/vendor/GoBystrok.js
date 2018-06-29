$('input[id="option2"]').focus(function() {
    $("#VoltaS").html('');
});

$('input[id="option1"]').focus(function() {
    $("#VoltaS").html('<input class="mdl-textfield__input mdl-color-text--orange-50" type="date" id="dateVolta">' + 
                      '<label class="mdl-textfield__label mdl-color-text--orange-50" for="dateVolta"></label>');
});
    
$("form[name='compraPassagem']").submit( function(event) {

    if ($("#Origem").val() === "" || $("#Destino").val() === "" || $("#dateIda").val() === "" || $("#dateVolta").val() === "") {
        alert("Falta preencher o(s) campo(s).");
    }
    event.preventDefault();
});


$("#senha2").focusout(function(){
    if (!($('#senha').val() === $('#senha2').val())) {
        alert('As senhas digitadas nao coincidem.');
    }
    console.log('Verificando senhas...');
});