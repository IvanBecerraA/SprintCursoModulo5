$(document).ready(function () {
    var table = $('#tablaCapacitaciones').DataTable()

    $('#tablaCapacitaciones tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected')
            $('#btnModalBorrar').attr('data-bs-target', '')
            $('#btnModalEditar').attr('data-bs-target', '')
        } else {
            table.$('tr.selected').removeClass('selected')
            $(this).addClass('selected')
            $('#btnModalBorrar').attr('data-bs-target', '#modalBorrar')
            $('#btnModalEditar').attr('data-bs-target', '#modalEditar')
        }
    })

    $('#btnModalBorrar').click(function () {
        var data = table.row('.selected').data()
        var seleccionadas = table.rows('.selected').data().length
        if (seleccionadas) {
            $('#idEliminacion').val(data[0])
        }
    })

    $('#btnModalEditar').click(function () {
        var data = table.row('.selected').data()
        var seleccionadas = table.rows('.selected').data().length
        if (seleccionadas) {
            $('#inputID').val(data[0])
            $('#inputIdCliente').val(data[1])
            $('#inputFecha').val(data[2])
            $('#inputHora').val(data[3])
            $('#inputLugar').val(data[4])
            $('#inputDuracion').val(data[5])
            $('#inputAsistentes').val(data[6])
        }
    })
})