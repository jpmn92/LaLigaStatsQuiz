package com.laligastatsquiz.laligastatsquiz.competiciones;

public enum SeleccionesInternacional implements Competicion{

    //Mundiales
    WC(0, 1003, "World Cup", "https://i.ibb.co/1LvJXBC/wcs.png", 36),
    WC2018(16, 16,"World Cup 2018", "https://vignette.wikia.nocookie.net/futbol/images/c/ca/2018_FIFA_World_Cup.png/revision/latest?cb=20180622085715", 36),
    WC2014(17, 17,"World Cup 2014", "https://vignette.wikia.nocookie.net/futbol/images/2/2f/Copa_Mundial_de_F%C3%BAtbol_de_2014.png/revision/latest?cb=20140617231722", 36),
    WC2010(18, 18,"World Cup 2010", "https://vignette.wikia.nocookie.net/revenge-history/images/e/ea/Sudafrica_2010_logo.png/revision/latest/scale-to-width-down/340?cb=20200822190858&path", 36),
    WC2006(19, 19,"World Cup 2006", "https://upload.wikimedia.org/wikipedia/en/thumb/6/6b/2006_FIFA_World_Cup.svg/1200px-2006_FIFA_World_Cup.svg.png", 36),
    WC2002(21, 21,"World Cup 2002", "https://upload.wikimedia.org/wikipedia/en/thumb/c/ce/2002_FIFA_World_Cup.svg/1200px-2002_FIFA_World_Cup.svg.png", 36),
    WC1998(22, 22,"World Cup 1998", "https://www.pngkey.com/png/full/390-3901272_the-1998-fifa-world-cup-was-the-16th.png", 36),
    WC1994(23, 23,"World Cup 1994", "https://vignette.wikia.nocookie.net/futbol/images/0/0b/1994fifawc.png/revision/latest?cb=20150723191950", 36),

    //Eurocopas
    EURO(0, 1004,"Euro", "https://i.ibb.co/kJSNrtn/euros.png", 37),
    EURO2016(10, 10,"Euro 2016", "https://memoriasdelfutbol.com/wp-content/uploads/2019/07/logo-euro-2016.png", 37),
    EURO2012(11, 11,"Euro 2012", "https://footballia.net/uploads/tournament/logo/9/large_844px-UEFA_Euro_2012_logo.svg.png", 37),
    EURO2008(12, 12,"Euro 2008", "https://upload.wikimedia.org/wikipedia/en/thumb/1/1a/UEFA_Euro_2008_Logo.svg/1200px-UEFA_Euro_2008_Logo.svg.png", 37),
    EURO2004(13, 13,"Euro 2004", "https://upload.wikimedia.org/wikipedia/en/thumb/3/39/UEFA_Euro_2004_logo.svg/1200px-UEFA_Euro_2004_logo.svg.png", 37),
    EURO2000(14, 14,"Euro 2000", "https://vignette.wikia.nocookie.net/logopedia/images/d/da/UEFA_Euro_2000_logo.svg/revision/latest/scale-to-width-down/340?cb=20150203215139", 37),
    EURO1996(15, 15,"Euro 1996", "https://upload.wikimedia.org/wikipedia/en/thumb/7/7b/UEFA_Euro_1996_logo.svg/1200px-UEFA_Euro_1996_logo.svg.png", 37),

    ALL(0, 1005,"WC + EURO", "https://i.ibb.co/BzzRRnY/internacional.png", 0);

    private int id;
    private int idPuntuacion;
    private String name;
    private String urlImage;
    private int country;
    private int tipo;

    SeleccionesInternacional(int id, int idPuntuacion, String name, String urlImage, int country) {
        this.id = id;
        this.idPuntuacion = idPuntuacion;
        this.name = name;
        this.urlImage = urlImage;
        this.country = country;
        this.tipo = 3;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getUrlImage() {
        return urlImage;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    @Override
    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int getIdPuntuacion() {
        return idPuntuacion;
    }

    public void setIdPuntuacion(int idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }
}
