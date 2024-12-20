package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField idTexto;
    private JTextField libroTexto;
    private JLabel Autor;
    private JTextField autorTexto;
    private JTextField precioText;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tableModeloLibros;

    @Autowired
    public LibroFrom(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
        iniciarForma();
        agregarButton.addActionListener(e -> agregarLibro());
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });
        modificarButton.addActionListener(e -> modificarLibro());
        eliminarButton.addActionListener(e -> eliminarLibro());
    }

    private void iniciarForma() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900, 700);
        // Para obtener las dimenciones de la ventana
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension tamanioPantalla = toolkit.getScreenSize();
        int x = (tamanioPantalla.width - getWidth() / 2);
        int y = (tamanioPantalla.height - getHeight() / 2);
        setLocation(x, y);
    }

    private void agregarLibro() {
        //Leer los valores del formulario
        if (libroTexto.getText().equals("")) {
            mostrarMensaje("Ingresa el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }
        var nombreLibro = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(precioText.getText());
        var existencias = Integer.parseInt(existenciasTexto.getText());
        // Creamos el objeto libro
        var libro = new Libro(null, nombreLibro, autor, precio, existencias);
        // libro.setNombreLibro(nombreLibro);
        // libro.setAutor(autor);
        // libro.setPrecio(precio);
        // libro.setExistencias(existencias);
        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agrego el libro");
        limpiarFormulario();
        listarLibros();
    }

    private void cargarLibroSeleccionado() {
        //Los indices de las columnas inician en cero
        var renglon = tablaLibros.getSelectedRow();
        if (renglon != -1) {
            String idLibro = tablaLibros.getModel().getValueAt(renglon, 0).toString();
            idTexto.setText(idLibro);
            String nombreLibro = tablaLibros.getModel().getValueAt(renglon, 1).toString();
            libroTexto.setText(nombreLibro);
            String autor = tablaLibros.getModel().getValueAt(renglon, 2).toString();
            autorTexto.setText(autor);
            String precio = tablaLibros.getModel().getValueAt(renglon, 3).toString();
            precioText.setText(precio);
            String existencias = tablaLibros.getModel().getValueAt(renglon, 4).toString();
            existenciasTexto.setText(existencias);

        }
    }

    private void modificarLibro() {
        if (this.idTexto.equals("")) {
            mostrarMensaje("Debes selecionar un registro en la tabla");
        } else {
            // Vereificamos que nombre del libro no sea nulo
            if (libroTexto.getText().equals("")) {
                mostrarMensaje("Digite el nombre del libro...");
                libroTexto.requestFocusInWindow();
                return;
            }
            // llenamos el objeto libro a actualizar
            int idLibro = Integer.parseInt(idTexto.getText());
            var nombreLibro = libroTexto.getText();
            var autor = autorTexto.getText();
            var precio = Double.parseDouble(precioText.getText());
            var existencias = Integer.parseInt(existenciasTexto.getText());
            var libro = new Libro(idLibro, nombreLibro, autor, precio, existencias);
            libroServicio.guardarLibro(libro);
            mostrarMensaje("Se modifico el libro...");
            limpiarFormulario();
            listarLibros();
        }
    }

    private void eliminarLibro() {
        var renglon = tablaLibros.getSelectedRow();
        if (renglon != -1) {
            String idLibro = tablaLibros.getModel().getValueAt(renglon,0).toString();
            String nombreLibro = tablaLibros.getModel().getValueAt(renglon,1).toString();
            var libro = new Libro();
            libro.setIdLibro(Integer.parseInt(idLibro));
            libro.setNombreLibro(nombreLibro);
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro N°: "+idLibro+"\nNombre: "+nombreLibro+"\nELIMINADO");
            limpiarFormulario();
            listarLibros();
        }else {
            mostrarMensaje("No se a seleccionado ningun libro de la tabla a eliminar");
        }
    }

    private void limpiarFormulario() {
        libroTexto.setText("");
        autorTexto.setText("");
        precioText.setText("");
        existenciasTexto.setText("");
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void createUIComponents() {
        idTexto = new JTextField("");
        idTexto.setVisible(false);
        this.tableModeloLibros = new DefaultTableModel(0, 5){
            // Evitamos que se puedan modificar los campos de la tabla
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        String[] cabecera = {"ID", "Libro", "Autor", "Precio", "Existncias"};
        this.tableModeloLibros.setColumnIdentifiers(cabecera);
        // Instanciar el el objeto de Jtable
        this.tablaLibros = new JTable(tableModeloLibros);
        // Evitamos que se seleccionen varios registros
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listarLibros();
    }

    private void listarLibros() {
        // limpiar la tabla
        tableModeloLibros.setRowCount(0);
        // Obtener los libros de la BD
        var libros = libroServicio.listarLibros();
        // Iteramos cada libro
        libros.forEach((libro) -> { // Función Lambda
            // Creamos cada registro para agregarlos a la tabla
            Object[] renglonLibro = {
                    libro.getIdLibro(),
                    libro.getNombreLibro(),
                    libro.getAutor(),
                    libro.getPrecio(),
                    libro.getExistencias()
            };
            this.tableModeloLibros.addRow(renglonLibro);
        });
    }
}
