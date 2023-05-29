
package com.mycompany.javaeat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class JavaEat extends JFrame {
    
    private Usuario usuario;
    private List<Usuario> listaUsuarios;    
    private List<Pedido> listaPedidos;
    private List<Restaurante> listaRestaurantes;
    private List<Comida> listaComidas;    

    
    private InterfazAdministrador interfazAdministrador;
    private InterfazEmpresa interfazEmpresa;
    private InterfazCliente interfazCliente;
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public JavaEat(List<Usuario> listaUsuarios, List<Pedido> listaPedidos, List<Restaurante> listaRestaurantes, List<Comida> listaComidas) {
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
        
        JComboBox<String> comboBoxTipoUsuario = new JComboBox<>();
        comboBoxTipoUsuario.addItem("Administrador");
        comboBoxTipoUsuario.addItem("Cliente");
        comboBoxTipoUsuario.addItem("Empresa");


        JButton buttonIniciarSesion = new JButton("Iniciar sesión");
        buttonIniciarSesion.setEnabled(false);
        
        buttonAdministrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazAdministrador administrador  = new InterfazAdministrador(listaUsuarios, listaRestaurantes, listaPedidos);
                administrador.mostrarInterfazAdministrador();
            }
        });

        buttonCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfazCliente cliente = new InterfazCliente( listaComidas, listaRestaurantes, listaPedidos, usuario);
                cliente.realizarRegistro();
                Usuario usuario = cliente.getUsuario();
                setUsuario(usuario);
                cliente.mostrarInterfazCliente();
            }
        });

        buttonEmpresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                interfazEmpresa.mostrarInterfazEmpresa();
            }
        }); 

        setLayout(new GridLayout(13, 1));
        add(new JLabel()); 
        add(new JLabel());
        add(buttonAdministrador);
        add(buttonCliente);
        add(buttonEmpresa);
        add(new JLabel()); 
        add(new JLabel());
        
        
        interfazAdministrador = new InterfazAdministrador(listaUsuarios, listaRestaurantes, listaPedidos);
        interfazCliente = new InterfazCliente(listaComidas, listaRestaurantes, listaPedidos, usuario );
        interfazEmpresa = new InterfazEmpresa();
    }    
  
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            List<Usuario> listaUsuarios = new ArrayList<>();            
            List<Pedido> listaPedidos = new ArrayList<>();
            List<Restaurante> listaRestaurantes = new ArrayList<>();
            List<Comida> listaComidas = new ArrayList<>();
            JavaEat ventana = new JavaEat(listaUsuarios, listaPedidos, listaRestaurantes, listaComidas );
            ventana.setVisible(true);
        });
    }
}
