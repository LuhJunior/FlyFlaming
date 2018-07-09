$('input[id="option2"]').focus(function() {
    $("#VoltaS").html('');
});

$('input[id="option1"]').focus(function() {
    $("#VoltaS").html('<input class="mdl-textfield__input mdl-color-text--orange-50" type="date" id="dateVolta">' + 
                      '<label class="mdl-textfield__label mdl-color-text--orange-50" for="dateVolta"></label>');
});
    
$("form[name='compraPassagem']").submit( function(event) {

    if ($("#Origem").val() === "" || $("#Destino").val() === "" || $("#dateIda").val() === "" || $("#dateVolta").val() === "") {
        ShowMensagemErro("Falta preencher o(s) campo(s).");
        event.preventDefault();
    }
    
    if ($("#dateIda").val() > $("#dateVolta").val()) {
        ShowMensagemErro("A data de ida selecionada é maior do que a da volta.");
        console.log('FALSO');
        event.preventDefault();
    }
    
    if ($("#dateIda").val() === $("#dateVolta").val()) {
        ShowMensagemErro("A data de ida selecionada e igual a da volta.");
        console.log('FALSO');
        event.preventDefault();
    }
    
    if (ComparaDataAtual($("#dateIda").val()) == 1) {
        ShowMensagemErro("Data de ida é menor que a data atual.");
        console.log('FALSO');
        event.preventDefault();
    }
    
    if (ComparaDataAtual($("#dateVolta").val()) == 1) {
        ShowMensagemErro("Data de volta menor que a data atual.");
        console.log('FALSO');
        event.preventDefault();
    }
   
});

function verificarCamposLogin(){
    var Campos = "";
    if(loginForm.CPF.value == "") Campos += "CPF";
    if(loginForm.Senha.value == ""){ if(Campos != "") Campos += ", Senha"; else Campos = "Senha";}
    if(Campos !== "") AlertPreencherCampos(Campos);
    return Campos === "";
}

function verificarCamposCadastro(){
    var Campos = "";
    if(cadastrarCliente.Nome.value == "") Campos = "Nome";
    if(cadastrarCliente.CPF.value == "") if(Campos != "") Campos += ", CPF"; else Campos = "CPF";
    if(cadastrarCliente.Email.value == "") if(Campos != "") Campos += ", Email";  else Campos = "Email";
    if(cadastrarCliente.Telefone.value == "") if(Campos != "") Campos += ", Telefone";  else Campos = "Telefone";
    if(cadastrarCliente.Rua.value == "") if(Campos != "") Campos += ", Rua";  else Campos = "Rua";
    if(cadastrarCliente.Bairro.value == "") if(Campos != "") Campos += ", Bairro";  else Campos = "Bairro";
    if(cadastrarCliente.Cidade.value == "") if(Campos != "") Campos += ", Cidade";  else Campos = "Cidade";
    if(cadastrarCliente.Estado.value == "") if(Campos != "") Campos += ", Estado";  else Campos = "Estado";
    if(cadastrarCliente.CEP.value == "") if(Campos != "") Campos += ", CEP";  else Campos = "CEP";
    if(Campos !== "") AlertPreencherCampos(Campos);
    return Campos === "";
}

function verificarCamposReclamacao(){
    var Campos = "";
    if(reclamacaoForm.codPassagem.value == "") Campos = "Código da Passagem";
    if(reclamacaoForm.descricao.value == "") if(Campos != "") Campos += ", Descrição"; else Campos = "Descrição"
    if(Campos !== "") AlertPreencherCampos(Campos);
    return Campos === "";
}

function verificarCamposCheckin(){
    var r = true;
    if(checkinForm.codPassagem.value == ""){
        alert("O campo Código da Passagem não está preenchido");
        r = false;
    }
    return r;
}

function verificarCamposPagamento(){
    var r = true;
    if(pagamentoForm.numCard.value == ""){
        alert("O campo Número do Cartão não está preenchido");
        r = false;
    }
    if(pagamentoForm.Senha.value == ""){
        alert("O campo Senha não está preenchido");
        r = false;
    }
    if(pagamentoForm.Parcelas.value == ""){
        alert("O campo Parcelas não está preenchido");
        r = false;
    }
    return r;
}

function verificarCamposTrocarSenha(){
    var Campos = "";
    if(trocarSenhaForm.Senha.value == "") Campos = "Senha";
    if(trocarSenhaForm.NovaSenha.value == "" || trocarSenhaForm.RepetirNovaSenha.value == "") Campos += ", Nova Senha";
    if(trocarSenhaForm.NovaSenha.value != trocarSenhaForm.RepetirNovaSenha.value) ShowMensagemErro("Os campo Nova Senha não estão iguais");
    if(Campos !== "") AlertPreencherCampos(Campos);
    return Campos === "" && trocarSenhaForm.NovaSenha.value == trocarSenhaForm.RepetirNovaSenha.value;
}
    
function verificarCheckarCancelar(valor){
    var i, nome
    if(valor.substring(0,7) == "checkin"){
        nome = "Checkin"
        i = valor.substring(8, valor.legth);
    }
    else{
        nome = "Cancelamento"
        i = valor.substring(9, valor.legth);
    }
    var checkin = document.getElementsByName("Checkin[]");
    var cancelamento = document.getElementsByName("Cancelamento[]");
    //ShowMensagemErro(checkin.value);
    if(nome == "Checkin" && checkin[i].value != "Pendente") ShowMensagemErro("O checkin já foi feito!");
    else if(nome == "Checkin" && cancelamento[i].value != "Pendente") ShowMensagemErro("Não pode fazer checkin em uma passagem cancelada!");
    else if(nome == "Cancelamento" && cancelamento[i].value != "Pendente") ShowMensagemErro("A Passagem já está cancelada!");
    else if(checkin[i].value != "Pendente") ShowMensagemErro("Não pode cancelar depois de ter feito checkin!");
    else{
        var DataSaida = document.getElementsByName("DataSaida[]");
        var HoraSaida = document.getElementsByName("HoraSaida[]");
        if(nome == "Checkin"){
            if(ComparaDataHoraAtual(ToYMD(DataSaida[i].value), HoraSaida[i].value) == 1){
                ShowMensagemErro("Não pode fazer checkin depois do horário do voo!");
                return false;
            }
        }
        else{
            if(ComparaDataHoraAtual(ToYMD(DataSaida[i].value), HoraSaida[i].value) == 1){
                ShowMensagemErro("Não pode cancelar depois do horário do voo!");
                return false;
            }
        }
    }
    return checkin[i].value == "Pendente" && cancelamento[i].value == "Pendente";
}

function ComparaDataHoraAtual(Data, Hora){
    Data = Data.split("-")
    Hora = Hora.split(":")
    var d = new Date(Data[0], Data[1]-1, Data[2], Hora[0], Hora[1], Hora[2]);
    var d2 = new Date();
    if(d2 < d) return -1
    else if (d == d2) return 0
    else return 1
}

function ComparaDataAtual(Data){
    Data = Data.split("-")
    var d = new Date(Data[0], Data[1]-1, Data[2]);
    var d2 = new Date();
    if(d2 < d) return -1
    else if (d == d2) return 0
    else return 1
}

function ToYMD(data){
    data = data.split("/")
    return data[2]+"-"+data[1]+"-"+data[0];
    
}

function ToDMY(data){
    data = data.split("-")
    return data[2]+"-"+data[1]+"-"+data[0];
}

function fMasc(objeto, mascara) {
    obj=objeto;
    masc=mascara;
    setTimeout("fMascEx()",1);
}

function fMascEx() {
        obj.value=masc(obj.value);
}

function mTel(tel) {
    tel=tel.replace(/\D/g,"");
    tel=tel.replace(/^(\d)/,"($1");
    tel=tel.replace(/(.{3})(\d)/,"$1)$2");
    if(tel.length == 9) {
            tel=tel.replace(/(.{1})$/,"-$1");
    } else if (tel.length == 10) {
            tel=tel.replace(/(.{2})$/,"-$1");
    } else if (tel.length == 11) {
            tel=tel.replace(/(.{3})$/,"-$1");
    } else if (tel.length == 12) {
            tel=tel.replace(/(.{4})$/,"-$1");
    } else if (tel.length > 12) {
            tel=tel.replace(/(.{4})$/,"-$1");
    }
    return tel;
}

function mCNPJ(cnpj){
    cnpj=cnpj.replace(/\D/g,"");
    cnpj=cnpj.replace(/^(\d{2})(\d)/,"$1.$2");
    cnpj=cnpj.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3");
    cnpj=cnpj.replace(/\.(\d{3})(\d)/,".$1/$2");
    cnpj=cnpj.replace(/(\d{4})(\d)/,"$1-$2");
    return cnpj;
}

function mCPF(cpf){
    cpf=cpf.replace(/\D/g,"");
    cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2");
    cpf=cpf.replace(/(\d{3})(\d)/,"$1.$2");
    cpf=cpf.replace(/(\d{3})(\d{1,2})$/,"$1-$2");
    return cpf;
}

function mCEP(cep){
    cep=cep.replace(/\D/g,"");
    cep=cep.replace(/^(\d{2})(\d)/,"$1.$2");
    cep=cep.replace(/\.(\d{3})(\d)/,".$1-$2");
    return cep;
}

function mNum(num){
    num=num.replace(/\D/g,"");
    return num;
}

function mCartao(v){
    v = v.replace(/\D/g,""); // Permite apenas dígitos
    v = v.replace(/(\d{4})/g, "$1."); // Coloca um ponto a cada 4 caracteres
    v = v.replace(/\.$/, ""); // Remove o ponto se estiver sobrando
    v = v.substring(0, 19)// Limita o tamanho
    return v;
}

function ShowMensagem(Mensagem){
    swal(Mensagem);
}

function ShowMensagemErro(Mensagem){
    swal(Mensagem, "","warning");
}

function ShowMensagemSucesso(Mensagem){
    swal(Mensagem, "","success");
}

function AlertPreencherCampos(Mensagem){
    swal("Preencha o(s) Campo(s)", Mensagem, "warning");
} 

$("#senha2").focusout(function(){
    if (!($('#senha').val() === $('#senha2').val())) {
        alert('As senhas digitadas nao coincidem.');
    }
    console.log('Verificando senhas...');
});

function clickReset ()
{
    var isChecked = false,
        clicked = $(this),
        set = $('.' + clicked.attr('class') + ':checked').not (clicked);

    if (isChecked = clicked.attr('checked'))
    {
        set.attr('checked', false);
    }
    return true;
}

$(function ()
{
    $('.test').click (clickReset);
});