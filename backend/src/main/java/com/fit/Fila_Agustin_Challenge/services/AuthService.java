package com.fit.Fila_Agustin_Challenge.services;

import com.fit.Fila_Agustin_Challenge.entities.Usuario;
import com.fit.Fila_Agustin_Challenge.exceptions.CampoVacioException;
import com.fit.Fila_Agustin_Challenge.exceptions.CrearCuentaException;
import com.fit.Fila_Agustin_Challenge.exceptions.IniciarSesionException;
import com.fit.Fila_Agustin_Challenge.exceptions.TokenException;
import com.fit.Fila_Agustin_Challenge.models.CrearCuentaRequestModel;
import com.fit.Fila_Agustin_Challenge.models.InicioSesionRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class AuthService {
    @Autowired
    private JWTService jwtService;
    @Autowired
    private UsuarioService usuarioService;

    public Usuario login(InicioSesionRequestModel inicioSesion){
        this.validarDatosInicioSesion(inicioSesion);
        Optional<Usuario> opUsuario = usuarioService.buscarPorCredenciales(inicioSesion.getNombreUsuario(), inicioSesion.getClave());
        if(!opUsuario.isPresent()) throw new IniciarSesionException("Las credenciales son incorrectas");
        return opUsuario.get();
    }

    public String crearToken(String nombreUsuario){
        String token                = jwtService.crearToken(nombreUsuario);
        return token;
    }

    private void validarDatosInicioSesion(InicioSesionRequestModel inicioSesion){
        if(inicioSesion.getNombreUsuario().equals(""))  throw new CampoVacioException("Falta completar el nombre de usuario");
        if(inicioSesion.getClave().equals(""))          throw new CampoVacioException("Falta completar la contraseña");
    }

    public Usuario crearCuenta(CrearCuentaRequestModel crearCuenta){
        this.validarDatosCrearCuenta(crearCuenta);
        Usuario usuario = new Usuario(crearCuenta.getNombreUsuario(), crearCuenta.getClave(), crearCuenta.getNombre(), crearCuenta.getApellido(), crearCuenta.getMail());
        return usuarioService.insert(usuario);
    }
    private void validarDatosCrearCuenta(CrearCuentaRequestModel crearCuenta){
        if(crearCuenta.getNombre().equals(""))          throw new CampoVacioException("Falta completar el nombre");
        if(crearCuenta.getApellido().equals(""))        throw new CampoVacioException("Falta completar el apellido");
        if(crearCuenta.getMail().equals(""))            throw new CampoVacioException("Falta completar el mail");
        if(crearCuenta.getNombreUsuario().equals(""))   throw new CampoVacioException("Falta completar el nombre de usuario");
        if(crearCuenta.getClave().equals(""))           throw new CampoVacioException("Falta completar la contraseña");
        if(!this.validarMail(crearCuenta.getMail()))    throw new CrearCuentaException("El mail es invalido");
        Optional<Usuario> opUsuarioNombre   = usuarioService.buscarPorNombreDeUsuario(crearCuenta.getNombreUsuario());
        if(opUsuarioNombre.isPresent())                 throw new CrearCuentaException("Nombre de usuario ya en uso");
        Optional<Usuario> opUsuarioMail     = usuarioService.buscarPorMail(crearCuenta.getMail());
        if(opUsuarioMail.isPresent())                   throw new CrearCuentaException("Mail ya en uso");
    }

    private boolean validarMail(String unMail){
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher = pattern.matcher(unMail);
        return matcher.find();
    }

    public void validarToken(String token){
        if(!jwtService.validarToken(token)) throw new TokenException("Token invalido");
    }
}
