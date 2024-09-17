package com.mh.biz;
import com.mh.dao.implement.HeladoDAOimpl;
import com.mh.dao.implement.VentaDAOimpl;
import com.mh.exceptions.*;
import com.mh.utils.Utils;
import com.mh.dao.pojo.*;
import java.time.LocalDate;
import java.util.List;

public class MaquinaHelado {

    private double monedero;
    private double ingresos;
    private final Utils util = new Utils();

    public Helado pedirHelado(String posicion) throws Exception {
        try (HeladoDAOimpl heladoImpl = new HeladoDAOimpl(); VentaDAOimpl ventaImpl = new VentaDAOimpl()) {
            Helado helado = heladoImpl.getHeladoByPosition(posicion);
            validarHelado(helado);
            actualizarMonederoYIngresos(helado);
            actualizarCantidadHelado(heladoImpl, helado);
            registrarVenta(ventaImpl, posicion, helado);
            return helado;
        } catch (Exception e) {
            throw e;
        }
    }

    private void validarHelado(Helado helado) throws Exception {
        if (helado == null) {
            throw new NotValidPositionException("La posición es incorrecta");
        } else if (this.monedero < helado.getPrecio()) {
            throw new NotEnoughMoneyException("No hay dinero suficiente");
        } else if (helado.getCantidad() <= 0) {
            throw new QuantityExceededException("La cantidad de helados es insuficiente");
        }
    }

    private void actualizarMonederoYIngresos(Helado helado) {
        this.ingresos += helado.getPrecio();
        this.monedero -= helado.getPrecio();
        this.ingresos = this.util.redondeoDosDecimales(this.ingresos);
        this.monedero = this.util.redondeoDosDecimales(this.monedero);
    }

    private void actualizarCantidadHelado(HeladoDAOimpl heladoImpl, Helado helado) throws Exception {
        helado.setCantidad(helado.getCantidad() - 1);
        heladoImpl.refreshHelado(helado);
    }

    private void registrarVenta(VentaDAOimpl ventaImpl, String posicion, Helado helado) throws Exception {
        Venta venta = new Venta(LocalDate.now().toString(), posicion, helado.getNombre(), helado.getPrecio(),
                helado.getTipo(), 1);
        ventaImpl.addVenta(venta);
    }

    @Override
    public String toString() {
        String result = "";
        try (HeladoDAOimpl heladoImpl = new HeladoDAOimpl()) {
            List<Helado> helados = heladoImpl.getHelados();
            for (Helado helado : helados) {
                result += helado.toString() + "\n";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public double getMonedero() {
        return monedero;
    }

    public void setMonedero(double monedero) {
        this.monedero = monedero;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
}
