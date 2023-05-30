package com.mycompany.javaeat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JavaEat extends JFrame {

    private Usuario usuario;
    private List<Usuario> listaUsuarios;
    private List<Pedido> listaPedidos;
    private List<Restaurante> listaRestaurantes;
    private List<Comida> listaComidas;
    private JComboBox<String> comboBoxTipoUsuario;

    private InterfazAdministrador interfazAdministrador;
    private InterfazEmpresa interfazEmpresa;
    private InterfazCliente interfazCliente;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public JavaEat(List<Usuario> listaUsuarios, List<Pedido> listaPedidos, List<Restaurante> listaRestaurantes, List<Comida> listaComidas) {
        this.listaUsuarios = listaUsuarios;
        this.listaPedidos = listaPedidos;
        this.listaRestaurantes = listaRestaurantes;
        this.listaComidas = listaComidas;

        setTitle("JAVAEAT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton buttonAdministrador = new JButton("Administrador");
        JButton buttonCliente = new JButton("Cliente");
        JButton buttonEmpresa = new JButton("Empresa");

        comboBoxTipoUsuario = new JComboBox<>();
        comboBoxTipoUsuario.addItem("Administrador");
        comboBoxTipoUsuario.addItem("Cliente");
        comboBoxTipoUsuario.addItem("Empresa");

        JButton buttonIniciarSesion = new JButton("Iniciar sesión");

        buttonAdministrador.addActionListener(e -> {
            InterfazAdministrador administrador = new InterfazAdministrador(listaUsuarios, listaRestaurantes, listaPedidos);
            administrador.mostrarInterfazAdministrador();
        });

        buttonCliente.addActionListener(e -> {
            InterfazCliente cliente = new InterfazCliente(listaComidas, listaRestaurantes, listaPedidos, usuario);
            cliente.mostrarInterfazCliente();
        });

        buttonEmpresa.addActionListener(e -> interfazEmpresa.mostrarInterfazEmpresa());

        buttonIniciarSesion.addActionListener(e -> {
            String selectedType = comboBoxTipoUsuario.getSelectedItem().toString();
            if (selectedType.equals("Administrador")) {
            } else if (selectedType.equals("Cliente")) {
            } else if (selectedType.equals("Empresa")) {
            }
            buttonIniciarSesion.setEnabled(false);
        });

        setLayout(new GridLayout(4, 3));
        add(new JLabel());
        add(new JLabel());
        add(buttonAdministrador);
        add(buttonCliente);
        add(buttonEmpresa);
        add(new JLabel());
        add(new JLabel());

        interfazAdministrador = new InterfazAdministrador(listaUsuarios, listaRestaurantes, listaPedidos);
        interfazCliente = new InterfazCliente(listaComidas, listaRestaurantes, listaPedidos, usuario);
        interfazEmpresa = new InterfazEmpresa();

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            List<Usuario> listaUsuarios = new ArrayList<>();
            List<Pedido> listaPedidos = new ArrayList<>();
            List<Restaurante> listaRestaurantes = new ArrayList<>();
            List<Comida> listaComidas = new ArrayList<>();
            JavaEat ventana = new JavaEat(listaUsuarios, listaPedidos, listaRestaurantes, listaComidas);
            ventana.setVisible(true);
        });
    }
}
