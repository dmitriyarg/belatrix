# belatrix
examen tecnico belatrix

    Revisión del codigo existente
        Todas las responsabilidades estan concentradas en una sola clase.
        El método “LogMessage” tiene responsabilidades de crear la conexión y de crear el logFile…
        Código difícil de ampliar, por ej. si se quiere usar otro filesystem o conectarse a otro tipo de base de datos.
        Argumento sin referencia “private boolean initialized”
        Map sin especificar tipo de argumentos.
        El constructor de la clase JobLogger tiene parámetros redundantes. Se podría usar tipo de mensaje (log Level) y tipo de salida.
        Como buena practica es pasarle el nombre de la clase al método Logger.getLogger(JobLogger.class.getName());
        L:40 posible NullPointerException.
        L:52-54 posible error de obtener parámetros.
        L:56 Aparentemente es a configuración para obtener la coneccion a las DB MySQL. Se va a fallar porque no se especifica el nombre de la base. El formato es: "jdbc:mysql://127.0.0.1:3306/database_name"
        El método de obtener la conexión debe estar separado en otra clase y ser invocado solamente en el caso si la salida del log es DB.
        L:59-70 Código mal escrito y repetido en L:83-93
        Tipo del atributo “int t” podría ser in String directamente.
        L:77 Error si el directorio no existe.
        El método de obtener crear logFile debe estar separado en otra clase y ser invocado solamente en el caso si la salida del log es archivo.
        L:83-93 Código repetido.
        L:106 A la DB se envía el mensaje sin formato
        Nombre de la tabla no es estandart y claramente sin la clave primaria.

