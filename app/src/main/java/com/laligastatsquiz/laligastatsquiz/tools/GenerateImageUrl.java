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


    public String getRandomAvatar() {

        ArrayList<LaLigaPlayer> laLigaPlayers = new ArrayList<>();

        Random r = new Random();
        int low = 0;
        int high = 36;
        int result = r.nextInt(high - low) + low;

        return laLigaPlayers.get(result).getPhotos().getPhoto().getBig();
    }


}
