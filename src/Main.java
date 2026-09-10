import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Libro libro1 = new Libro(
                "Cien años de soledad",
                "Gabriel García Márquez",
                "1",
                "Novela",
                1967,
                3);

        Libro libro2 = new Libro(
                "El amor en los tiempos del cólera",
                "Gabriel García Márquez",
                "2",
                "Novela",
                1985,
                2);

        Libro libro3 = new Libro(
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                "3",
                "Novela",
                1605,
                4);

        Libro libro4 = new Libro(
                "El principito",
                "Antoine de Saint-Exupéry",
                "4",
                "Infantil",
                1943,
                5);

        Libro libro5 = new Libro(
                "Harry Potter y la piedra filosofal",
                "J. K. Rowling",
                "5",
                "Fantasía",
                1997,
                3);

        Libro libro6 = new Libro(
                "Sapiens",
                "Yuval Noah Harari",
                "6",
                "Ciencia",
                2011,
                2);

        Libro libro7 = new Libro(
                "Breve historia del tiempo",
                "Stephen Hawking",
                "7",
                "Ciencia",
                1988,
                2);

        Libro libro8 = new Libro(
                "La vorágine",
                "José Eustasio Rivera",
                "8", "Novela",
                1924,
                3);

        Libro libro9 = new Libro(
                "El olvido que seremos",
                "Héctor Abad Faciolince",
                "9",
                "Novela",
                2006,
                2);

        Libro libro10 = new Libro(
                "Veinte poemas de amor y una canción desesperada",
                "Pablo Neruda",
                "10",
                "Poesía",
                1924,
                4);

        biblioteca.agregarLibros(libro1);
        biblioteca.agregarLibros(libro2);
        biblioteca.agregarLibros(libro3);
        biblioteca.agregarLibros(libro4);
        biblioteca.agregarLibros(libro5);
        biblioteca.agregarLibros(libro6);
        biblioteca.agregarLibros(libro7);
        biblioteca.agregarLibros(libro8);
        biblioteca.agregarLibros(libro9);
        biblioteca.agregarLibros(libro10);

        boolean continuar = true;

        while (continuar) {

            String opcion = JOptionPane.showInputDialog("SISTEMA DE BIBLIOTECA" +
                    "\n" + "1. Agregar libro" +
                    "\n" + "2. Mostrar todos los libros" +
                    "\n" + "3. Buscar por autor" +
                    "\n" + "4. Eliminar libro" +
                    "\n" + "5. Salir" +
                    "\n" + "Escriba una opción:");

            if (opcion == null) {
                continuar = false;
            } else if (opcion.equals("1")) {

                String titulo = JOptionPane.showInputDialog("Título:");
                String autor = JOptionPane.showInputDialog("Autor:");
                String codigo = JOptionPane.showInputDialog("Código:");
                String genero = JOptionPane.showInputDialog("Género:");
                String publicacionTexto = JOptionPane.showInputDialog("Año de publicación:");
                String copiasTexto = JOptionPane.showInputDialog("Copias disponibles:");

                if (titulo.isEmpty() || autor.isEmpty() || codigo.isEmpty() ||
                        genero.isEmpty() || publicacionTexto.isEmpty() || copiasTexto.isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
                } else {

                    try {

                        int publicacion = Integer.parseInt(publicacionTexto);
                        int copias = Integer.parseInt(copiasTexto);

                        boolean repetido = false;

                        for (Libro libro : biblioteca.mostrarTodo()) {

                            if (libro.getCodigo().equals(codigo)) {
                                repetido = true;
                            }
                        }

                        if (repetido) {

                            JOptionPane.showMessageDialog(null, "Ese código ya existe.");

                        } else if (publicacion > 2026) {

                            JOptionPane.showMessageDialog(null, "El año no puede ser mayor a 2026.");

                        } else if (copias < 0) {

                            JOptionPane.showMessageDialog(null, "Las copias no pueden ser menores a 0.");

                        } else {

                            Libro nuevoLibro = new Libro(titulo, autor, codigo, genero, publicacion, copias);

                            biblioteca.agregarLibros(nuevoLibro);

                            JOptionPane.showMessageDialog(null, "Libro agregado correctamente.");
                        }

                    } catch (NumberFormatException e) {

                        JOptionPane.showMessageDialog(null, "El año y las copias deben ser números.");
                    }
                }
            } else if (opcion.equals("2")) {

                String mensaje = "LIBROS DE LA BIBLIOTECA\n";

                for (Libro libro : biblioteca.mostrarTodo()) {

                    mensaje += libro + "\n\n";
                }

                JOptionPane.showMessageDialog(null, mensaje);
            } else if (opcion.equals("3")) {

                String autor = JOptionPane.showInputDialog("Escriba el autor:");

                if (autor != null && !autor.trim().isEmpty()) {

                    String mensaje = "LIBROS DE " + autor + "\n";

                    for (Libro libro : biblioteca.filtrarAutor(autor)) {

                        mensaje += libro + "\n";
                    }

                    JOptionPane.showMessageDialog(null, mensaje);

                } else {

                    JOptionPane.showMessageDialog(null, "Debe escribir un autor.");
                }

            } else if (opcion.equals("4")) {

                String codigo = JOptionPane.showInputDialog("Escriba el código del libro:");

                if (codigo != null && !codigo.trim().isEmpty()) {

                    boolean encontrado = false;

                    for (Libro libro : biblioteca.mostrarTodo()) {

                        if (libro.getCodigo().equals(codigo)) {

                            encontrado = true;

                            int respuesta = JOptionPane.showConfirmDialog(null, "¿Desea eliminar este libro?" + "\n" + libro, "Eliminar", JOptionPane.YES_NO_OPTION);

                            if (respuesta == JOptionPane.YES_OPTION) {

                                biblioteca.eliminarLibros(codigo);

                                JOptionPane.showMessageDialog(null, "Libro eliminado correctamente.");
                            }

                            break;
                        }
                    }

                    if (!encontrado) {

                        JOptionPane.showMessageDialog(null, "No se encontró ese libro.");
                    }

                } else {

                    JOptionPane.showMessageDialog(null, "Debe escribir un código.");
                }
            } else if (opcion.equals("5")) {

                continuar = false;

                JOptionPane.showMessageDialog(null, "Programa terminado.");
            } else {

                JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }
}