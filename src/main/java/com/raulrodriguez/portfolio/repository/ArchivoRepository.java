package com.raulrodriguez.portfolio.repository;

import com.raulrodriguez.portfolio.model.Usuario;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ArchivoRepository {
    private static final Logger logger = Logger.getLogger(ArchivoRepository.class.getName());
    private static final String USUARIOS_FILE = "data/usuarios.json";
    private final ObjectMapper mapper;

    public ArchivoRepository() {
        this.mapper = new ObjectMapper();
        crearDirectorioData();
    }

    private void crearDirectorioData() {
        File dir = new File("data");
        if (!dir.exists()) {
            boolean creado = dir.mkdir();
            if (creado) {
                logger.info("Directorio 'data' creado correctamente");
            }
        }
    }

    public void guardarUsuarios(List<Usuario> usuarios) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(USUARIOS_FILE), usuarios);
        logger.info("Usuarios guardados en archivo: " + USUARIOS_FILE);
    }

    public List<Usuario> cargarUsuarios() throws IOException {
        File file = new File(USUARIOS_FILE);
        if (!file.exists()) {
            logger.warning("Archivo no encontrado, se creará uno nuevo al guardar");
            return new ArrayList<>();
        }
        return mapper.readValue(file, new TypeReference<List<Usuario>>() {});
    }

    public void guardarUsuarioIndividual(Usuario usuario) throws IOException {
        List<Usuario> usuarios = cargarUsuarios();
        usuarios.removeIf(u -> u.getId() == usuario.getId());
        usuarios.add(usuario);
        guardarUsuarios(usuarios);
        logger.info("Usuario guardado/actualizado: " + usuario.getId());
    }

    public void eliminarUsuario(int id) throws IOException {
        List<Usuario> usuarios = cargarUsuarios();
        boolean eliminado = usuarios.removeIf(u -> u.getId() == id);
        if (eliminado) {
            guardarUsuarios(usuarios);
            logger.info("Usuario eliminado: " + id);
        } else {
            logger.warning("Usuario no encontrado para eliminar: " + id);
        }
    }
}
