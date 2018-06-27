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
    //event.preventDefault();
});

function verificarCamposLogin(){
    var Campos = "";
    if(loginForm.CPF.value == "") Campos += "CPF";
    if(loginForm.Senha.value == "") Campos += ", Senha";
    if(Campos !== "") AlertPreencherCampos(Campos);
    return Campos === "";
}

function verificarCamposCadastro(){
    var Campos = "";
    if(cadastroForm.Nome.value == "") Campos = "Nome";
    if(cadastroForm.CPF.value == "") Campos += ", CPF";
    if(cadastroForm.Email.value == "") Campos += ", Email";
    if(cadastroForm.Telefone.value == "")Campos += ", Telefone";
    if(cadastroForm.Rua.value == "") Campos += ", Rua";
    if(cadastroForm.Bairro.value == "") Campos += ", Bairro";
    if(cadastroForm.Cidade.value == "") Campos += ", Cidade";
    if(cadastroForm.Estado.value == "") Campos += ", Estado";
    if(cadastroForm.CEP.value == "") Campos += ", CEP";
    if(Campos !== "") AlertPreencherCampos(Campos);
    return Campos === "";
}

function verificarCamposReclamacao(){
    var r = true;
    if(reclamacaoForm.codPassagem.value == ""){
        alert("O campo Código da Passagem não está preenchido");
        r = false;
    }
    if(reclamacaoForm.descricao.value == ""){
        alert("O campo Descrição não está preenchido");
        r = false;
    }
    return r;
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

function ShowMensagem(Mensagem){
    swal(Mensagem);
}

function ShowMensagemErro(Mensagem){
    swal(Mensagem, "warning");
}

function AlertPreencherCampos(Mensagem){
    swal("Preencha o(s) Campo(s)", Mensagem, "warning");
} 