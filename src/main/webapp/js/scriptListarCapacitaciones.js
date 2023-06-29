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
            $('#btnModalBorrar').attr('data-bs-target', '#modalEditar')
        }
    })

    $('#btnModalBorrar').click(function () {
        var data = table.row('.selected').data()
        var seleccionadas = table.rows('.selected').data().length
        if (seleccionadas) {
            $('#idEliminacion').val(data[0])
        }
    })
})