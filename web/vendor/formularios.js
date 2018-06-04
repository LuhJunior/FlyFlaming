function verificarCampos(){
    var r = true;
    var tam = document.forms[0].elements.length;
    for(var i=0; i<tam-1; i++){
        if(document.forms[0].elements[i].value == ""){
            alert("O campo " + document.forms[0].elements[i].name + " não está preenchido");
            r = false;
        }
    }
    return r;
}

function verificarCamposLogin(){
    var r = true;
    if(loginForm.CPF.value == ""){
        alert("O campo CPF não está preenchido");
        r = false;
    }
    if(loginForm.Senha.value == ""){
        alert("O campo senha não está preenchido");
        r = false;
    }
    return r;
}

function verificarCamposCadastro(){
    var r = true;
    if(cadastroForm.Nome.value == ""){
        alert("O campo Nome não está preenchido");
        r = false;
    }
    if(cadastroForm.CPF.value == ""){
        alert("O campo CPF não está preenchido");
        r = false;
    }
    if(cadastroForm.Email.value == ""){
        alert("O campo E-mail não está preenchido");
        r = false;
    }
    if(cadastroForm.Telefone.value == ""){
        alert("O campo Telefone não está preenchido");
        r = false;
    }
    if(cadastroForm.Cidade.value == ""){
        alert("O campo Cidade não está preenchido");
        r = false;
    }
    if(cadastroForm.Estado.value == ""){
        alert("O campo Estado não está preenchido");
        r = false;
    }
    if(cadastroForm.CEP.value == ""){
        alert("O campo CEP não está preenchido");
        r = false;
    }
    return r;
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
    if(checkinForm.CPF.value == ""){
        alert("O campo CPF não está preenchido");
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
    var r=true;
    if(trocarSenhaForm.Senha == ""){
        alert("O campo Senha não está preenchido");
        r = false;
    }
    if(trocarSenhaForm.NovaSenha == "" || trocarSenhaForm.RepetirNovaSenha == ""){
        alert("O campo Nova Senha não está preenchido");
        r = false;
    }
    if(trocarSenhaForm.NovaSenha != trocarSenhaForm.RepetirNovaSenha){
        alert("Os campo Nova Senha não estão iguais");
        r = false;
    }
    return r;
}