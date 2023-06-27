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
})