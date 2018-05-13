$(function() {
    var $table = $('table');
    var $deletar = $('.acao-deletar', $table);

    $deletar.on('click', function(){
        var $isOk = confirm('Confirmar \'APAGAR REGISTRO\' ?');
        if($isOk){
            return true;
        }
        return false;
    });
});