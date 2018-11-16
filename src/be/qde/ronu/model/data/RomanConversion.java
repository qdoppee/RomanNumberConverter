package be.qde.ronu.model.data;

public interface RomanConversion {

    /**
     * Get the Class of the origin of the conversion
     *
     * @return A not null Class
     */
    Class from();

    /**
     * Get the Class of the destination of the conversion
     *
     * @return A not null Class
     */
    Class to();

}
