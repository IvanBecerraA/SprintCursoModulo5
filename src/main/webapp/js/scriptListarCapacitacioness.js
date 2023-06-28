$(document).ready(function () {
    var table = $('#tablaCapacitaciones').DataTable()

    $('#tablaCapacitaciones tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected')
        } else {
            table.$('tr.selected').removeClass('selected')
            $(this).addClass('selected')
        }
    })

    $('#btnBorrar').click(function () {
        var data = table.row('.selected').data()
        if (data) {
            console.log("FUNCIONA")
        }
        table.row('.selected').remove().draw(false)
    })

    $('#btnEditar').click(function () {
        var data = table.row('.selected').data()
        if (data) {
            $('#idEliminacion').val(data[0])
        }

    })

    $('#btnModalBorrar').click(function () {
        var data = table.row('.selected').data()
        var seleccionadas = table.rows('.selected').data().length
        if (seleccionadas) {
            $('#idEliminacion').val(data[0])
            console.log(seleccionadas)
        }

    })
})