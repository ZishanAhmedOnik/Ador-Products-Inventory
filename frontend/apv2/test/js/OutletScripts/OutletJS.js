$(document).ready(function() {
    $('table tbody tr').click(function(){
        var tableFieldoutletID = $(this).children("td:nth-child(1)").html();
        var tableFieldoutletName = $(this).children("td:nth-child(2)").html();

        $("#outletID").val(tableFieldoutletID);

        $("#outletName").val(tableFieldoutletName);
        $("#isNewOutlet").val('false');
    });

    $('#newButton').click(function() {
        $("#outletID").val('0');

        $("#outletName").val('');
        $("#isNewOutlet").val(true);
    });

    $('#submitButton').click(function() {
        var saveCancel = false;

        $outletID = $('#outletID').val();
        $outletName = $('#outletName').val();

        if($outletID.length == 0 || $outletName.length == 0) {
            $('#localErrorModal').modal('show');
            saveCancel = true;
        }

        if(!saveCancel) {
            $('#saveConfirmModal').modal('show');
        }

        return;
    });

    $('#saveConfirm').click(function() {
        $('#outletForm').submit();
    });

    $('#deleteButton').click(function() {
        var deleteCancel = false;

        $outletID = $('#outletID').val();
        $outletName = $('#outletName').val();

        if($outletID.length == 0 || $outletName.length == 0) {
            $('#localErrorModal').modal('show');
            deleteCancel = true;
        }

        if(!deleteCancel) {
            $('#deleteConfirmModal').modal('show');
        }

        return;
    });

    $('#deleteConfirm').click(function() {
        var form = $('#outletForm');
        form.attr('action', '/AdorProducts/public/outletDelete');

        form.submit();
    });
});
