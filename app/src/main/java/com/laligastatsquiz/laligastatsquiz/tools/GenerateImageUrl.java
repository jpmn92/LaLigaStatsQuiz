package com.laligastatsquiz.laligastatsquiz.tools;

import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPhoto;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPhotoSize;
import com.laligastatsquiz.laligastatsquiz.beans.LaLigaPlayer;

import java.util.ArrayList;
import java.util.Random;

public class GenerateImageUrl {


    public ArrayList<LaLigaPlayer> getLaLigaPlayers() {

        ArrayList<LaLigaPlayer> laLigaPlayers = new ArrayList<>();

        LaLigaPlayer laLigaPlayer = generatePlayer("Karim Benema", "https://assets.laliga.com/squad/2019/t186/p19927/1024x1113/p19927_t186_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Leo Messi", "https://assets.laliga.com/squad/2019/t178/p19054/128x139/p19054_t178_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Vinicius Jr", "https://assets.laliga.com/squad/2019/t186/p246333/256x278/p246333_t186_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Martin Ødegaard", "https://assets.laliga.com/squad/2019/t188/p184029/128x139/p184029_t188_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Royston Drenthe", "https://2img.net/h/futhead.cursecdn.com/static/img/14/players/177752.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Thomas Gravesen", "https://fmdataba.com/images/p/273859.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Dmytro Chygrynsky", "https://www.aekfc.gr/uploads/IMAGES/47976/NTMITRO-TSIGKRINSKI-pismall.png?lm=B355E4A16BAD97733A9ECFEF98FA3714");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Cristiano Ronaldo", "https://fmdataba.com/images/p/147187.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Dani Güiza", "https://fmdataba.com/images/p/274289.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Kaka´", "https://fmdataba.com/images/p/274657.png");
        laLigaPlayers.add(laLigaPlayer);

        laLigaPlayer = generatePlayer("Julien Faubert", "https://fmdataba.com/images/p/224656.png");
        laLigaPlayers.add(laLigaPlayer);

        // De primera
        laLigaPlayer = generatePlayer("Gerard", "https://assets.laliga.com/squad/2019/t449/p93721/256x278/p93721_t449_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Iago Aspas", "https://assets.laliga.com/squad/2019/t176/p40270/256x278/p40270_t176_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Luis Suárez", "https://assets.laliga.com/squad/2019/t178/p39336/256x278/p39336_t178_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Raul Garcia", "https://assets.laliga.com/squad/2019/t174/p18498/256x278/p18498_t174_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("L. Ocampos", "https://assets.laliga.com/squad/2019/t179/p121117/256x278/p121117_t179_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Budimir", "https://assets.laliga.com/squad/2019/t181/p94273/256x278/p94273_t181_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Mata", "https://assets.laliga.com/squad/2019/t1450/p109270/256x278/p109270_t1450_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Roger M. S.", "https://assets.laliga.com/squad/2019/t855/p109702/256x278/p109702_t855_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Lucas", "https://assets.laliga.com/squad/2019/t173/p155851/256x278/p155851_t173_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ángel", "https://assets.laliga.com/squad/2019/t1450/p56419/256x278/p56419_t1450_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Joselu", "https://assets.laliga.com/squad/2019/t173/p61316/256x278/p61316_t173_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("M. Gómez", "https://assets.laliga.com/squad/2019/t191/p215206/256x278/p215206_t191_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Morata", "https://assets.laliga.com/squad/2019/t175/p88482/256x278/p88482_t175_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Loren", "https://assets.laliga.com/squad/2019/t185/p432751/256x278/p432751_t185_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Chimy Avila", "https://assets.laliga.com/squad/2019/t450/p205992/256x278/p205992_t450_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Willian J.", "https://assets.laliga.com/squad/2019/t188/p73314/256x278/p73314_t188_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Oyarzabal", "https://assets.laliga.com/squad/2019/t188/p219000/256x278/p219000_t188_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Óscar", "https://assets.laliga.com/squad/2019/t957/p223757/256x278/p223757_t957_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Parejo", "https://assets.laliga.com/squad/2019/t191/p51952/256x278/p51952_t191_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Joaquín", "https://assets.laliga.com/squad/2019/t185/p10316/256x278/p10316_t185_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("S. Cazorla", "https://assets.laliga.com/squad/2019/t449/p19524/256x278/p19524_t449_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Sergio Ramos", "https://assets.laliga.com/squad/2019/t186/p17861/256x278/p17861_t186_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Orellana", "https://assets.laliga.com/squad/2019/t953/p48854/256x278/p48854_t953_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Griezmann", "https://assets.laliga.com/squad/2019/t178/p76650/256x278/p76650_t178_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Braithwaite", "https://assets.laliga.com/squad/2019/t178/p68690/256x278/p68690_t178_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Y. En-Nesyri", "https://assets.laliga.com/squad/2019/t179/p234991/256x278/p234991_t179_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Vidal", "https://assets.laliga.com/squad/2019/t178/p42565/256x278/p42565_t178_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Portu", "https://assets.laliga.com/squad/2019/t188/p88550/256x278/p88550_t188_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Carlos Fernández", "https://assets.laliga.com/squad/2019/t5683/p176189/256x278/p176189_t5683_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Fekir", "https://assets.laliga.com/squad/2019/t185/p166552/256x278/p166552_t185_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("B. Mayoral", "https://assets.laliga.com/squad/2019/t855/p199248/256x278/p199248_t855_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Isak", "https://assets.laliga.com/squad/2019/t188/p219168/256x278/p219168_t188_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Canales", "https://assets.laliga.com/squad/2019/t185/p56448/256x278/p56448_t185_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ruben Garcia", "https://assets.laliga.com/squad/2019/t450/p130026/256x278/p130026_t450_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Charles L. C.", "https://assets.laliga.com/squad/2019/t953/p86349/256x278/p86349_t953_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("João Félix", "https://assets.laliga.com/squad/2019/t175/p428399/256x278/p428399_t175_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Saúl", "https://assets.laliga.com/squad/2019/t175/p89335/256x278/p89335_t175_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Enes Ünal", "https://assets.laliga.com/squad/2019/t192/p168636/256x278/p168636_t192_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Sergi Guardiola", "https://assets.laliga.com/squad/2019/t192/p89850/256x278/p89850_t192_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("De Jong", "https://assets.laliga.com/squad/2019/t179/p53041/256x278/p53041_t179_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Toko Ekambi", "https://assets.laliga.com/squad/2019/t449/p193454/256x278/p193454_t449_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("R. Torres", "https://assets.laliga.com/squad/2019/t450/p90402/256x278/p90402_t450_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Machis", "https://assets.laliga.com/squad/2019/t5683/p111133/256x278/p111133_t5683_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Williams", "https://assets.laliga.com/squad/2019/t174/p197334/256x278/p197334_t174_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Correa", "https://assets.laliga.com/squad/2019/t175/p156223/256x278/p156223_t175_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ansu Fati", "https://fmdataba.com/images/p/154398.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Molina", "https://assets.laliga.com/squad/2019/t1450/p76555/256x278/p76555_t1450_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Gameiro", "https://assets.laliga.com/squad/2019/t191/p42779/256x278/p42779_t191_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Antonio Puertas", "https://assets.laliga.com/squad/2019/t5683/p156301/256x278/p156301_t5683_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Soldado", "https://assets.laliga.com/squad/2019/t5683/p17926/256x278/p17926_t5683_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Salva Sevilla", "https://assets.laliga.com/squad/2019/t181/p55354/256x278/p55354_t181_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Dani Rodriguez", "https://assets.laliga.com/squad/2019/t181/p80906/256x278/p80906_t181_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Kike G.", "https://assets.laliga.com/squad/2019/t953/p61597/256x278/p61597_t953_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Muniain", "https://assets.laliga.com/squad/2019/t174/p76012/256x278/p76012_t174_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        //Mujeres
        laLigaPlayer = generatePlayer("Jennifer Hermoso", "https://assets.laliga.com/squad/2019/t9121/p165364/256x278/p165364_t9121_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Asisat Oshoala", "https://assets.laliga.com/squad/2019/t9121/p193629/256x278/p193629_t9121_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ainize Barea", "https://assets.laliga.com/squad/2019/t15762/p434496/256x278/p434496_t15762_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Oriana Yoselin Altuve", "https://assets.laliga.com/squad/2019/t13321/p459037/256x278/p459037_t13321_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Jade Boho", "https://assets.laliga.com/squad/2019/t14503/p97172/256x278/p97172_t14503_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Nahikari García", "https://assets.laliga.com/squad/2019/t13324/p176169/256x278/p176169_t13324_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Gabriela Antonia", "https://assets.laliga.com/squad/2019/t15762/p459039/256x278/p459039_t15762_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Alexia Putellas", "https://assets.laliga.com/squad/2019/t9121/p165355/256x278/p165355_t9121_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Lucía García", "https://assets.laliga.com/squad/2019/t12034/p206238/256x278/p206238_t12034_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Alba Redondo", "https://assets.laliga.com/squad/2019/t13319/p191675/256x278/p191675_t13319_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ángela Sosa", "https://assets.laliga.com/squad/2019/t11212/p434288/256x278/p434288_t11212_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Mª Paz Vilas", "https://assets.laliga.com/squad/2019/t13329/p242635/256x278/p242635_t13329_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Eva Navarro", "https://assets.laliga.com/squad/2019/t13319/p454316/256x278/p454316_t13319_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Verónica Charlyn", "https://assets.laliga.com/squad/2019/t11212/p97440/256x278/p97440_t11212_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ludmila Da Silva", "https://assets.laliga.com/squad/2019/t11212/p428299/256x278/p428299_t11212_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        //De segunda
        laLigaPlayer = generatePlayer("Stuani", "https://assets.laliga.com/squad/2019/t2893/p49464/256x278/p49464_t2893_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("L. Suárez", "https://assets.laliga.com/squad/2019/t190/p432838/256x278/p432838_t190_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Stoichkov", "https://assets.laliga.com/squad/2019/t5233/p198524/256x278/p198524_t5233_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Darwin Nuñez", "https://assets.laliga.com/squad/2019/t1564/p447203/256x278/p447203_t1564_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Alex", "https://assets.laliga.com/squad/2019/t1737/p88479/256x278/p88479_t1737_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Ortuño", "https://assets.laliga.com/squad/2019/t187/p59059/256x278/p59059_t187_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);
        laLigaPlayer = generatePlayer("Merquelanz", "https://assets.laliga.com/squad/2019/t5741/p201177/256x278/p201177_t5741_2019_1_001_000.png");
        laLigaPlayers.add(laLigaPlayer);

        return laLigaPlayers;
    }

    private LaLigaPlayer generatePlayer(String nickname, String image) {
        LaLigaPlayer laLigaPlayer = new LaLigaPlayer();
        laLigaPlayer.setNickname(nickname);
        laLigaPlayer.setPhotos(new LaLigaPhoto());
        laLigaPlayer.getPhotos().setPhoto(new LaLigaPhotoSize());
        laLigaPlayer.getPhotos().getPhoto().setBig(image);
        return laLigaPlayer;
    }

    //NBA

    public String checkPlayerImage(int idJugador) {


        String urlImage = "";

        switch (idJugador) {


            //claver
            case 201964:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3972.png&w=350&h=254";
                break;

            //earl clark
            case 201947:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3971.png&w=350&h=254";
                break;

            //byron mullens
            case 201957:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/4005.png";
                break;


            //beaubois
            case 201958:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3963.png";
                break;

            //shasha pavlovic
            case 2562:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2172.png";
                break;

            //haseem thabeet
            case 201934:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/4016.png&w=350&h=254";
                break;

            //jan vesely
            case 202686:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/4165.png";
                break;

            //aaron gray
            case 201189:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3207.png";
                break;

            //acie law
            case 201151:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3219.png";
                break;

            //sean may
            case 101118:
                urlImage = "https://s.lnb.fr/img/player/photo/32388/32388_37.png";
                break;

            //ike diogu
            case 101113:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2750.png";
                break;

            //eduardo najera
            case 2059:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/591.png";
                break;

            //jarvis hayes
            case 2553:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1980.png";
                break;

            //torkine shengeila
            case 203129:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/6623.png";
                break;

            //jasekevicius
            case 101180:
                urlImage = "hhttps://usathoopshype.files.wordpress.com/2018/06/i_6d_f6_40_sarunas-jasikevicius.png?w=190";
                break;

            //demarr johnson
            case 2035:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/398.png";
                break;

            //michael doleac
            case 1720:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Michael-Doleac-2K-550x402.png";
                break;

            //pete myers
            case 939:
                urlImage = "https://history.bulls.com/wp-content/uploads/2016/04/pete-myers.png";
                break;

            //reggie williams 1990
            case 199:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Reggie-Williams-2K.png";
                break;

            //robert horry
            case 109:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Robert-Horry-2K.png";
                break;

            //eddie johnson
            case 77144:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Eddie-Johnson-2K.png";
                break;

            //dee brown
            case 244:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Dee-Brown-2K.png";
                break;

            //jeff malone
            case 117:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Jeff-Malone-2K.png";
                break;
            //james worthy
            case 1460:
                urlImage = "https://www.2kratings.com/wp-content/uploads/James-Worthy-2K.png";
                break;
            //chuck person
            case 456:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Chuck-Person-2K.png";
                break;

            //micheal williams
            case 52:
                urlImage = "https://www.mundodeportivo.com/r/GODO/MD/p3/Baloncesto/Imagenes/2015/12/02/Recortada/img_jihuguet_20151202-131117_imagenes_md_terceros_michael_williams-ky0H--652x492@MundoDeportivo-Web.jpg";
                break;
            //derek harper
            case 157:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Derek-Harper-2K.png";
                break;

            //tom chambers
            case 1472:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Tom-Chambers-2K.png";
                break;

            //bj armstrong
            case 769:
                urlImage = "https://www.2kratings.com/wp-content/uploads/B.J.-Armstrong-2K.png";
                break;

            //hot rod williams
            case 73:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Hot-Rod-Williams-2K.png";
                break;

            //doc rivers
            case 470:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Doc-Rivers-2K.png";
                break;

            //charles smith
            case 293:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Charles-Smith-2K.png";
                break;

            //david wingate
            case 766:
                urlImage = "https://www.2kratings.com/wp-content/uploads/David-Wingate-2K.png";
                break;

            //rony seikaly
            case 938:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Rony-Seikaly-2K-550x402.png";
                break;

            //sam perkins
            case 64:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Sam-Perkins-2K.png";
                break;

            //vernon maxwell
            case 137:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Vernon-Maxwell-2K.png";
                break;

            //kevin willis
            case 788:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Kevin-Willis-2K.png";
                break;

            //abdul rauf
            case 51:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Mahmoud-Abdul-Rauf-2K.png";
                break;

            //mark price
            case 899:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Mark-Price-2K.png";
                break;

            //devean george
            case 1904:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Devean-George-2K.png";
                break;

            //mike james
            case 2229:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1051.png&w=350&h=254";
                break;

            //keyon dooling
            case 2039:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/209.png";
                break;

            //terry porter
            case 345:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Terry-Porter-2K.png";
                break;

            //robert pack
            case 123:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Robert-Pack-2K.png";
                break;

            //bobby jackson
            case 1517:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Bobby-Jackson-2K.png";
                break;

            //will perdue
            case 781:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Will-Perdue-2K.png";
                break;

            //howard eisley
            case 458:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Howard-Eisley-2K.png";
                break;

            //dennis scott
            case 192:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Dennis-Scott-2K.png";
                break;

            //walter mccarty
            case 962:
                urlImage = "https://www.screensandrhymes.com/wp-content/uploads/2015/04/WALTER-McCARTY-Graphic.png";
                break;

            //isaiah rider
            case 375:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Isaiah-Rider-2K.png";
                break;

            //laphonso ellis
            case 111:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Laphonso-Ellis-2K.png";
                break;

            //lindsey hunter
            case 283:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Lindsey-Hunter-2K.png";
                break;

            //gary trent sr
            case 718:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Gary-Trent-2K.png";
                break;

            //matt geiger
            case 761:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Matt-Geiger-2K.png";
                break;

            //stacey augmon
            case 278:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Stacey-Augmon-2K.png";
                break;

            //sam mitchell
            case 417:
                urlImage = "https://usathoopshype.files.wordpress.com/2018/05/i_8d_f3_06_sam-mitchell.png?w=190";
                break;

            //kenny anderson
            case 72:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Kenny-Anderson-2K.png";
                break;

            //rik smits
            case 22:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Rik-Smits-2K.png";
                break;

            //bryon rusell
            case 935:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Bryon-Russell-2K.png";
                break;

            //brian shaw
            case 216:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Brian-Shaw-2K.png";
                break;

            //jumaine jones
            case 1908:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Jumaine-Jones-2K.png";
                break;

            //popeye jones
            case 461:
                urlImage = "https://cdn140.picsart.com/236809178088212.png?type=webp&to=min&r=1024";
                break;

            //marko jaric
            case 2060:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/387.png";
                break;

            //darvin ham
            case 1032:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Darvin-Ham-2K.png";
                break;

            //corie blount
            case 916:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Corie-Blount-2K.png";
                break;

            //damon jones
            case 1800:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Damon-Jones-2K.png";
                break;

            //doug west
            case 28:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Doug-West-2K.png";
                break;

            //alvin williams
            case 1541:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Alvin-Williams-2K.png";
                break;

            //jeff foster
            case 1902:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/250.png";
                break;

            //jason collins
            case 2215:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/987.png";
                break;

            //clifford robinson
            case 361:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Clifford-Robinson-2K.png";
                break;

            //antonio davis
            case 213:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Antonio-Davis-2K.png";
                break;

            //etan thomas
            case 2041:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/851.png";
                break;

            //carlos arroyo
            case 2306:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/1055.png";
                break;

            //charlie ward
            case 369:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Charlie-Ward-2K.png";
                break;

            //ervin johnson
            case 911:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Ervin-Johnson-2K.png";
                break;

            //michael olowakandi
            case 1709:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Michael-Olowokandi-2K.png";
                break;

            //jaque vaugh
            case 1521:
                urlImage = "https://usathoopshype.files.wordpress.com/2018/03/i_c3_7e_87_jacque-vaughn.png?w=190&h=190&crop=1";
                break;

            //bryant reeves
            case 735:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Bryant-Reeves-2K-550x402.png";
                break;

            //shandon anderson
            case 1000:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Shandon-Anderson-2K.png";
                break;

            //christian laettner
            case 363:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Christian-Laettner-2K.png";
                break;

            //hakeem
            case 165:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Hakeem-Olajuwon-2K.png";
                break;

            //johny newman
            case 271:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Johnny-Newman-2K.png";
                break;

            //aaron williams
            case 1425:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Aaron-Williams-2K.png";
                break;

            //jared jefries
            case 2407:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1717.png";
                break;

            //greg anthony
            case 21:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Greg-Anthony-2K.png";
                break;

            //jamal mashburn
            case 469:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Jamal-Mashburn-2K-1.png";
                break;

            //eric snow
            case 727:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Eric-Snow-2K.png";
                break;

            //adam morrison
            case 200747:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/3016.png";
                break;

            //vin baker
            case 452:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Vin-Baker-2K.png";
                break;
            //jonny flynn
            case 201938:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3985.png";
                break;

            //jerry west
            case 78497:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Jerry-West-2K.png";
                break;
            //vladimir radmanovic
            case 2209:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1016.png";
                break;
            //john starks
            case 317:
                urlImage = "https://www.2kratings.com/wp-content/uploads/John-Starks-2K.png";
                break;
            //ron harper
            case 166:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Ron-Harper-2K.png";
                break;
            //brian cardinal
            case 2073:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/130.png";
                break;
            //linas kleiza
            case 101132:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2770.png";
                break;

            //ryan gomes
            case 101155:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2757.png";
                break;

            //jason maxiell
            case 101131:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2775.png&w=350&h=254";
                break;

            //andray blatche
            case 101154:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/2746.png";
                break;

            //joel przybilla
            case 2038:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/682.png";
                break;

            //reggie evans
            case 2501:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/1828.png";
                break;

            //andris biedrins
            case 2740:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2427.png";
                break;

            //darko milicic
            case 2545:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2171.png";
                break;
            //sebastian telfair
            case 2742:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2417.png&w=350&h=254";
                break;

            //flip murray
            case 2436:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1777.png";
                break;
            //anthony carter
            case 1853:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/137.png";
                break;

            //daniel gibson
            case 200789:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3006.png&w=350&h=254";
                break;

            //raja bell
            case 1952:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/49.png";
                break;
            //hakim warrick
            case 101124:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2794.png&w=350&h=254";
                break;

            //kwame brown
            case 2198:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/981.png";
                break;

            //matt carroll
            case 2679:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2211.png";
                break;
            //morris peterson
            case 2050:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Morris-Peterson-2K.png";
                break;

            //jamaal magloire
            case 2048:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/498.png";
                break;

            //tony battie
            case 1499:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/45.png&w=350&h=254";
                break;

            //larry hughes
            case 1716:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/356.png";
                break;

            //johan petro
            case 101130:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2780.png";
                break;

            //travis outlaw
            case 2566:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2015.png";
                break;

            //jannero pargo
            case 2457:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1821.png";
                break;

            //aaron mckie
            case 243:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Aaron-McKie-2K.png";
                break;

            //brendan haywood
            case 2217:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1000.png&w=350&h=254";
                break;

            //ricky davis
            case 1729:
                urlImage = "https://big3.com/wp-content/uploads/2018/05/GHOST-BALLERS__RICKY-DAVIS.png";
                break;

            //chucky atkins
            case 1088:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/26.png";
                break;

            //earl watson
            case 2248:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1027.png";
                break;

            //horace grant
            case 270:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Horace-Grant-Chicago-Bulls-2K.png";
                break;

            //keith bogans
            case 2586:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1995.png";
                break;

            //rick fox
            case 296:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Rick-Fox-2K.png";
                break;

            //delonte west
            case 2753:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2422.png";
                break;

            //ronny turiaf
            case 101142:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/2789.png";
                break;

            //carlos delfino
            case 2568:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/1999.png";
                break;

            //rashad mccants
            case 101119:
                urlImage = "https://dev.big3.com/wp-content/uploads/2018/05/TRILOGY_MCCANTS_RASHAD.png";
                break;

            //tyrus thomas
            case 200748:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3032.png";
                break;

            //josh boone
            case 200767:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2990.png";
                break;

            //kenny smith
            case 181:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Kenny-Smith-2K.png";
                break;

            //nate mcmillan
            case 203:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Nate-McMillian-2K.png";
                break;

            //mehmet okur
            case 2246:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1014.png";
                break;

            //donyell marshall
            case 923:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Donyell-Marshall-2K.png";
                break;

            //byron scott
            case 2:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Byron-Scott-2K.png";
                break;

            //landry fields
            case 202361:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Landry-Fields-2K.png";
                break;

            //luke walton
            case 2575:
                urlImage = "https://s.yimg.com/it/api/res/1.2/OeJFDROgIZ6K2zhKZbL5Yw--~A/YXBwaWQ9eW5ld3M7dz0zMDA7aD0yMDA7cT0xMDA-/https://s.yimg.com/xe/i/us/sp/v/nba_cutout/players_l/20130626/3735.png";
                break;

            //eddie house
            case 2067:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/348.png&w=350&h=254";
                break;

            //daequan cook
            case 201161:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3196.png&w=350&h=254";
                break;

            //quentin richardson
            case 2047:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/703.png";
                break;

            //malik rose
            case 990:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Malik-Rose-2K-550x401.png";
                break;

            //mickael pietrus
            case 2554:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2173.png";
                break;

            //kurt thomas
            case 703:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/846.png";
                break;

            //spud webb
            case 892:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Spud-Webb-2K.png";
                break;
            //glen davis
            case 201175:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3200.png";
                break;
            //sean elliot
            case 251:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Sean-Elliott-2K.png";
                break;
            //deshawn stevenson
            case 2052:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/808.png";
                break;
            //ronnie brewer
            case 200758:
                urlImage = "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fheadshots%2Fnba%2Fplayers%2Ffull%2F2991.png";
                break;
            //sabonis
            case 717:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Arvydas-Sabonis-2K.png";
                break;
            //tom gugliotta
            case 339:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Tom-Gugliotta-2K.png";
                break;
            //muggsy bogues
            case 177:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Muggsy-Bogues-2K.png";
                break;
            //isaiah thomas
            case 78318:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Isiah-Thomas-2K.png";
                break;
            //scott skiles
            case 101:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Scott-Skiles-2K.png";
                break;
            //tim hardaway sr
            case 896:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Tim-Hardaway-2K.png";
                break;
            //larry johnson
            case 913:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Larry-Johnson-2K.png";
                break;
            //petrovic
            case 77845:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Drazen-Petrovic-2K.png";
                break;
            //mark jackson
            case 349:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Mark-Jackson-2K-1.png";
                break;
            //sprewell
            case 84:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Latrell-Sprewell-2K.png";
                break;
            //glen rice
            case 779:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Glen-Rice-2K.png";
                break;

            //Schrempf
            case 96:
                urlImage = "https://www.2kratings.com/wp-content/uploads/Detlef-Schrempf-2K.png";
                break;
            //david robinson
//            case 764:
//                urlImage = "https://webjolunba.com/caras/david_robinson.png";
//                break;
            //steve nash
            case 959:
                urlImage = "https://i.dlpng.com/static/png/219514_preview.png";
                break;

            //derek fisher
            case 965:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/246.png";
                break;

            //shane battier
            case 2203:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/976.png";
                break;

            //michael redd
            case 2072:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/692.png";
                break;

            //jason kidd
            case 467:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/429.png";
                break;

            //Ray allen
            case 951:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/9.png";
                break;

            //jamison
            case 1712:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/385.png";
                break;

            //jason stackhouse
            case 711:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/802.png";
                break;

            //jermaine
            case 979:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/615.png";
                break;

            //rashard lewis
            case 1740:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/469.png";
                break;
            //juwan howard
            case 436:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/351.png";
                break;

            //jason richardson
            case 2202:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1018.png";
                break;

            //tony parker
            case 2225:
                urlImage = "https://nba-players.herokuapp.com/players/Parker/Tony";
                break;

            //chauncey billups
            case 1497:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/63.png";
                break;

            //boozer
            case 2430:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1703.png";
                break;

            //al harrington
            case 1733:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/308.png";
                break;

            //maggete
            case 1894:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/497.png";
                break;
            //odom
            case 1885:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/617.png";
                break;

            //gerald wallace
            case 2222:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/1026.png";
                break;

            //brandon roy
            case 200750:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/3027.png";
                break;

            //nate robinson
            case 101126:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2782.png";
                break;
            //chris duhon
            case 2768:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2377.png";
                break;

            //rip hamilton
            case 1888:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/294.png";
                break;

            //shawn marion
            case 1890:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/510.png";
                break;

            //kirilenko
            case 1905:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/434.png";
                break;

            //andrew bynum
            case 101115:
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/headshots/nba/players/full/2748.png";
                break;

            //stephen jackson
            case 1536:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/378.png";
                break;

            //francisco garcia
            case 101128:
                urlImage = "https://3.bp.blogspot.com/-bopDVYYRH2A/Uz9ibGtm3xI/AAAAAAAAXs0/ZkXJA4oq0mE/s1600/i.png";
                break;

            //ridnour
            case 2557:
                urlImage = "https://a.espncdn.com/i/headshots/nba/players/full/1985.png";
                break;


            default:
                urlImage = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/" + idJugador + ".png";

        }


        return urlImage;
    }

    //WNBA
    public String checkWNBAPlayerImage(int idJugador) {


        String urlImage = "";

        switch (idJugador) {


            default:
                urlImage = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/wnba/" + idJugador + ".png";

        }


        return urlImage;
    }

    public String checkWNBATeamImage(String equipo) {

        String urlImage = "";

        switch (equipo) {

            case "wnba":
//                urlImage = "https://www.goodvinilos.com/6444/pegatina-logo-nba.jpg";
                urlImage = "https://a.espncdn.com/combiner/i?img=/i/teamlogos/leagues/500/wnba.png&w=288&h=288&transparent=true";
                break;

            case "orl":

                urlImage = "https://upload.wikimedia.org/wikipedia/en/d/d5/OrlandoMiracle.png";

                break;

            case "cle":

                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/6/62/ClevelandRockers.png/220px-ClevelandRockers.png";

                break;

            case "mia":

                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/6/61/MiamiSol.png/220px-MiamiSol.png";

                break;

            case "por":

                urlImage = "https://sportsteamhistory.com/wp-content/uploads/2020/04/portland_fire_2000-2002.png";

                break;


            default:
                urlImage = "https://a.espncdn.com/i/teamlogos/wnba/500/" + equipo + ".png";

        }


        return urlImage;
    }

    //NCAA


    public String checkTeamImage(String equipo) {

        String urlImage = "";

        switch (equipo) {

            case "NBA":
//                urlImage = "https://www.goodvinilos.com/6444/pegatina-logo-nba.jpg";
                urlImage = "https://cdn.bleacherreport.net/images/team_logos/328x328/nba.png";
                break;

            case "NOH":
                urlImage = "https://i.pinimg.com/originals/77/6a/3a/776a3a8005d7c176db429f7ce54367f9.png";
                break;
            case "NOK":
                urlImage = "https://i.pinimg.com/originals/77/6a/3a/776a3a8005d7c176db429f7ce54367f9.png";
                break;

            case "SEA":
                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Seattle_SuperSonics_logo.svg/1200px-Seattle_SuperSonics_logo.svg.png";
                break;

            case "VAN":
                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/1/1e/Vancouver_Grizzlies_logo.svg/1200px-Vancouver_Grizzlies_logo.svg.png";
                break;

            case "CIN":
                urlImage = "https://worldsportlogos.com/wp-content/uploads/2019/07/Cincinnati-Royals-emblem-1972.png";
                break;

            case "NJN":
                urlImage = "https://vignette.wikia.nocookie.net/baloncesto/images/8/88/New_Jersey_Nets_logo.png";
                break;

            default:
                urlImage = "https://a.espncdn.com/i/teamlogos/nba/500/" + equipo + ".png";

        }


        return urlImage;
    }

    public String checkCollegeImage(String college) {

        String urlImage = "";

        switch (college) {

            //EUROPA


            case "Paris Basket Racing":
                urlImage = "https://upload.wikimedia.org/wikipedia/en/c/c7/Paris_Basket_Racing_logo.gif";
                break;

            case "FC Barcelona Basquet (Spain)":
                urlImage = "https://i.pinimg.com/originals/4e/87/0c/4e870c6d61be9306bd9681554b0df83d.png";
                break;

            case "Real Madrid Baloncesto (Spain)":
                urlImage = "https://upload.wikimedia.org/wikipedia/an/thumb/c/c7/Logo_Real_Madrid.svg/500px-Logo_Real_Madrid.svg.png";
                break;

            case "Limoges CSP (France)":
                urlImage =
                        "https://www.proballers.com/api/getTeamLogo?id=6 ";
                break;

            case "KK Olimpija (Slovenia)":
                urlImage =
                        "https://upload.wikimedia.org/wikipedia/en/thumb/d/d4/KK_Olimpija_logo.svg/1200px-KK_Olimpija_logo.svg.png";
                break;

            case "BC Lietuvos rytas (Lithuania)":
                urlImage =
                        "https://i.pinimg.com/originals/f3/3b/d1/f33bd10915be0a8ef261aaa34eacdb68.png";
                break;

            case "KK Partizan (Serbia)":
                urlImage =
                        "https://2.bp.blogspot.com/-GZCY8okzj7I/WYcqiGVhwxI/AAAAAAABN08/W_BY9yefW68ua-o_SXfm_eL-2JzRx4Y2ACLcBGAs/s1600/FK%2BPartizan.png";
                break;

            case "SIG Strasbourg (France)":
                urlImage =
                        "https://nakara-sport.com/wp-content/uploads/2017/09/SIG2-1.png";
                break;

            case "CB Gran Canaria (Spain)":
                urlImage =
                        "https://cdn.scores24.ru/upload/team/origin/701/daf/aad92bbce5b3e194eb675a80f054f72cb9.png";
                break;

            case "KK Vrsac (Serbia)":
                urlImage =
                        "https://upload.wikimedia.org/wikipedia/en/c/c5/Kkvrsac.png";
                break;

            case "Red Star Belgrade (Serbia)":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/soccer/500/2290.png";
                break;

            case "Shanghai Sharks (China)":
                urlImage =
                        "https://upload.wikimedia.org/wikipedia/en/3/38/Shanghai_Sharks_logo.png";
                break;


            //HIGH SCHOOL


            case "Saint Vincent-Saint Mary":
                urlImage = "https://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/340/2017/12/20150221/stvm_leprechaun_white_outline_transparent_background.png";
                break;

            case "Lower Merion":
                urlImage = "https://s3-us-west-2.amazonaws.com/scorestream-team-profile-pictures/14600/20181010205637_599_mascot720Near.png";
                break;

            case "Farragut Career Academy":
                urlImage = "https://farragut.org/wp-content/uploads/2015/03/BluejacketsLogoVG_Tilt-Light-1.png";
                break;
            case "Mount Zion Christian Academy":
                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/d/de/MZCS_Emblem.gift.gif/250px-MZCS_Emblem.gift.gif";
                break;
            case "Cypress Creek High School":
                urlImage = "https://s3-us-west-2.amazonaws.com/sportshub2-uploads-prod/files/sites/1574/2018/02/09142848/logo_outline.png";
                break;


            //NCAA

            case "Santa Clara":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/2541.png";
                break;

            case "Connecticut":
                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Connecticut_Huskies_logo.svg/1200px-Connecticut_Huskies_logo.svg.png";
                break;

            case "Georgetown":
                urlImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Georgetown_Hoyas_logo.svg/598px-Georgetown_Hoyas_logo.svg.png";
                break;

            case "Marquette":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/269.png";
                break;

            case "Arizona":
                urlImage = "https://a3.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F12.png";
                break;

            case "Duke":
                urlImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Duke_Blue_Devils_logo.svg/1200px-Duke_Blue_Devils_logo.svg.png";
                break;

            case "Michigan State":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/127.png";
                break;

            case "Oklahoma":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/201.png";
                break;

            case "Texas":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/251.png";
                break;

            case "West Virginia":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/277.png";
                break;

            case "Alabama":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/333.png";
                break;

            case "Kentucky":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/96.png";
                break;

            case "Villanova":
                urlImage = "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F222.png";
                break;

            case "Boston College":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/103.png";
                break;
            case "Missouri":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/142.png";
                break;
            case "Oregon":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/2483.png";
                break;
            case "Texas Tech":
                urlImage = "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2641.png";
                break;
            case "Miami (FL)":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/2390.png";
                break;
            case "Maryland":
                urlImage = "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F120.png";
                break;
            case "Georgia Tech":
                urlImage = "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F120.png";
                break;
            case "Vanderbilt":
                urlImage = "https://a.espncdn.com/i/teamlogos/ncaa/500/238.png";
                break;

            case "Murray State":
                urlImage = " https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F93.png ";
                break;

            case "Virginia":
                urlImage =
                        "https://a3.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F258.png";
                break;


            case "North Carolina":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F153.png";
                break;

            case "Gonzaga":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2250.png";
                break;

            case "Indiana":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F84.png";
                break;

            case "Auburn":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2.png";
                break;

            case "Virginia Tech":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2.png";
                break;

            case "Washington":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F264.png";
                break;

            case "Tennessee":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/2633.png";
                break;

            case "Florida State":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/52.png";
                break;

            case "Michigan":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/130.png";
                break;

            case "Southern California":
                urlImage =
                        "https://a3.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F30.png";
                break;


            case "Georgia":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F61.png";
                break;

            case "Stanford":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/24.png";
                break;

            case "Purdue":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/2509.png";
                break;

            case "North Carolina State":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fsoccer%2F500%2F5642.pn";
                break;

            case "Arkansas":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=/i/teamlogos/ncaa/500/8.png";
                break;


            case "Wyoming":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/2751.png";
                break;

            case "Nebraska":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F158.png";
                break;

            case "Iowa State":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F66.png";
                break;

            case "Mississippi State":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F344.png";
                break;


            case "College of Charleston":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F232.png";
                break;

            case "San Diego":
                urlImage =
                        "https://a3.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F21.png";
                break;

            case "Hofstra":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2275.png";
                break;

            case "California-Los Angeles":
                urlImage =
                        "https://a3.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F26.png";
                break;

            case "Yale":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/43.png";
                break;


            case "Kansas":
                urlImage =
                        "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2305.png";
                break;

            case "Louisville":
                urlImage =
                        "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F97.png";
                break;

            case "Creighton":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F156.png";
                break;

            case "Wake Forest":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/154.png";
                break;

            case "Syracuse":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F183.png";
                break;

            case "Utah":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F254.png";
                break;

            case "Colorado":
                urlImage =
                        "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F38.png";
                break;

            case "Kansas State":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/2306.png";
                break;

            case "California":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F25.png";
                break;
            case "Southern Methodist":
                urlImage =
                        "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2567.png";
                break;

            case "Oklahoma State":
                urlImage =
                        "https://a.espncdn.com/i/teamlogos/ncaa/500/197.png";
                break;

            case "Houston":
                urlImage =
                        "https://a1.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fsoccer%2F500%2F17391.png";
                break;

            case "South Carolina":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2579.png";
                break;

            case "Xavier":
                urlImage =
                        "https://a2.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fsoccer%2F500%2F5712.png";
                break;

            case "Valparaiso":
                urlImage =
                        "https://a.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fncaa%2F500%2F2674.png";
                break;


            case "Clemson":
                urlImage =
                        "https://a4.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fsoccer%2F500%2F5629.png";
                break;


            default:
//                urlImage = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/dd/NCAA_logo.svg/1200px-NCAA_logo.svg.png";

                urlImage = "https://vignette.wikia.nocookie.net/logopedia/images/d/da/NBA_Draft_%281990s-2000%29.png";

//                urlImage = "https://seeklogo.com/images/N/nba-draft-logo-510F0C293C-seeklogo.com.png";
        }



        return urlImage;
    }

    //GLEAGUE

    public String checkGLeaguePlayerImage(int idJugador) {


        String urlImage = "";

        switch (idJugador) {


            default:
                urlImage = "https://ak-static.cms.nba.com/wp-content/uploads/headshots/dleague/" + idJugador + ".png";

        }


        return urlImage;
    }

    public String checkGLeagueTeamImage(String equipo) {

        String urlImage = "";

        switch (equipo) {

            case "gleague":
//                urlImage = "https://www.goodvinilos.com/6444/pegatina-logo-nba.jpg";
                urlImage = "https://a3.espncdn.com/combiner/i?img=%2Fi%2Fteamlogos%2Fleagues%2F500%2Fnba_gleague.png";
                break;


            case "rno":

                urlImage = "https://www.thesportsdb.com/images/media/team/badge/7hcet91586422790.png";
                break;

            case "spg":

                urlImage = "https://www.proballers.com/api/getTeamLogo?id=2034&width=300";
                break;

            case "bak":

                urlImage = "https://www.proballers.com/api/getTeamLogo?id=1755";
                break;

            case "lad":

                urlImage = "https://upload.wikimedia.org/wikipedia/en/thumb/f/fd/Los_Angeles_D-Fenders_logo.svg/220px-Los_Angeles_D-Fenders_logo.svg.png";
                break;

            case "tul":

                urlImage = "https://vignette.wikia.nocookie.net/logopedia/images/8/81/Tulsa_66ers_logo.svg";
                break;

            case "ida":

                urlImage = "https://www.proballers.com/api/getTeamLogo?id=868";
                break;

            case "abq":

                urlImage = "https://content.sportslogos.net/logos/17/2122/full/legu604fgo658ktghphb.gif";
                break;

            case "ana":

                urlImage = "https://vignette.wikia.nocookie.net/prosportsteams/images/7/7c/Anaheim_Arsenal.gif";
                break;

            case "dak":

                urlImage = "https://content.sportslogos.net/logos/17/2126/full/e9jbrghodt1yfcfeuuwp.gif";
                break;

            case "col":

                urlImage = "https://i.pinimg.com/originals/1a/80/be/1a80beacfa913064dd7795348029b637.gif";
                break;

            case "uta":

                urlImage = "https://www.proballers.com/api/getTeamLogo?id=1753";
                break;


            default:
                urlImage = "https://a.espncdn.com/i/teamlogos/nba-development/500-dark/" + equipo + ".png";




        }


        return urlImage;
    }


    public String getRandomAvatar() {

        ArrayList<String> images = new ArrayList<String>();

        ArrayList<LaLigaPlayer> laLigaPlayers = new ArrayList<>();

//
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612745/2019/260x190/201935.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612749/2019/260x190/203507.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612757/2019/260x190/203081.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612747/2019/260x190/2544.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612744/2019/260x190/201939.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612742/2019/260x190/1629029.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612747/2019/260x190/203076.png");
//        images.add("https://i.dlpng.com/static/png/219514_preview.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612759/2015/260x190/1495.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/893.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612742/2018/260x190/1717.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612751/2019/260x190/201142.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612751/2019/260x190/202681.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612747/2015/260x190/977.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612755/2019/260x190/203954.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612746/2019/260x190/202695.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612746/2019/260x190/202331.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612743/2019/260x190/203999.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612748/2019/260x190/202710.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612750/2019/260x190/1626157.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612740/2019/260x190/1629627.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612760/2019/260x190/101108.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612748/2018/260x190/2548.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/406.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612744/2019/260x190/202691.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612762/2019/260x190/1628378.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612758/2019/260x190/1627741.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612749/2018/260x190/2200.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1710.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/978.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/2547.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/1610612747/2016/260x190/1897.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1449.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/23.png");
//        images.add("https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/252.png");


        Random r = new Random();
        int low = 0;
        int high = 36;
        int result = r.nextInt(high - low) + low;

        return laLigaPlayers.get(result).getPhotos().getPhoto().getBig();
    }


}
