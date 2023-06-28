$(document).ready(function() {
    $("#formCrearCapacitacion").validate({
        rules: {
            dia: {
                required: true
            },
            hora: {
                required: true
            },
            direccion: {
                required: true
            },
            duracion: {
                required: true,
                min: 1
            },
            cantidadAsistentes: {
                required: true,
                min: 1
            }
        }
    })

    jQuery.extend(jQuery.validator.messages, {
        required: "Este campo es obligatorio.",
        number : "Este campo debe contener solo números",
        minlength: jQuery.validator.format("Ingresa al menos {0} carácteres."),
        min: jQuery.validator.format("Ingresa un valor minimo de {0}."),
    })
})