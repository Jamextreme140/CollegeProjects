/*
 * Alumno: Macias Bustamante Jaime Humberto
 * Numero de control: 21170384
 * Materia: Topicos Avanzados de Programacion
 * Unidad: 1
 * Proyecto: Barcos
 * Horario: 9:00 a 10:00
 * Fecha: 8/03/2024
 * Profesor: Dr. Clemente Garcia Gerardo
 */

import backend.Controller;
import backend.Model;
import view.View;

public class App {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        View view = new View();
        Controller ctrl = new Controller(view, model);
        view.addListeners(ctrl);
        view.setVisible(true);
        ctrl.addButtonImages();
    }
}
