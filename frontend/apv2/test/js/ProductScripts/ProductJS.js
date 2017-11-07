
    $(document).ready(function() {
        $('table tbody tr').click(function(){
            var tableFieldproductNumber = $(this).children("td:nth-child(1)").html();
            var tableFieldProductName = $(this).children("td:nth-child(2)").html();
            var tableFieldProductPrice = $(this).children("td:nth-child(3)").html();

            $("#productNumber").val(tableFieldproductNumber);
            $("#productNumber").attr('readonly', true);

            $("#productName").val(tableFieldProductName);

            $('#productPrice').val(tableFieldProductPrice);

            $("#isNewProduct").val('false');
        });

        $('#newButton').click(function() {
            $("#productNumber").val('');
            $("#productNumber").attr('readonly', false);

            $("#productName").val('');
            $("#productPrice").val('');
            $("#isNewProduct").val(true);
        });

        $('#submitButton').click(function() {
            var saveCancel = false;

            $productNumber = $('#productNumber').val();
            $productName = $('#productName').val();
            $productPrice = $('#productPrice').val();

            if($productNumber.length == 0 || $productName.length == 0 | $productPrice.length == 0) {
                $('#localErrorModal').modal('show');
                saveCancel = true;
            }

            if(!saveCancel) {
                $('#saveConfirmModal').modal('show');
            }

            return;
        });

        $('#saveConfirm').click(function() {
            $('#productForm').submit();
        });

        $('#deleteButton').click(function() {
            var deleteCancel = false;

            $productNumber = $('#productNumber').val();
            $productName = $('#productName').val();

            if($productNumber.length == 0 || $productName.length == 0) {
                $('#localErrorModal').modal('show');
                deleteCancel = true;
            }

            if(!deleteCancel) {
                $('#deleteConfirmModal').modal('show');
            }

            return;
        });

        $('#deleteConfirm').click(function() {
            var form = $('#productForm');
            form.attr('action', '/AdorProducts/public/productDelete');

            form.submit();
        });
    });
