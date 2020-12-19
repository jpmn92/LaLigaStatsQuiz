package com.laligastatsquiz.laligastatsquiz.tools;

import com.laligastatsquiz.laligastatsquiz.beans.FootballPlayer;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPhoto;
import com.laligastatsquiz.laligastatsquiz.beans.FootballPhotoSize;

import java.util.ArrayList;
import java.util.Random;

public class GenerateImageUrl {

    public ArrayList<FootballPlayer> getFootballPlayers() {

        ArrayList<FootballPlayer> footballPlayers = new ArrayList<>();



        FootballPlayer footballPlayer = generatePlayer("Karim Benema", "https://assets.laliga.com/squad/2019/t186/p19927/1024x1113/p19927_t186_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Eden Hazard", "https://assets.laliga.com/squad/2020/t186/p42786/2048x2225/p42786_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Marcelo", "https://assets.laliga.com/squad/2020/t186/p39563/2048x2225/p39563_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Modric", "https://assets.laliga.com/squad/2020/t186/p37055/2048x2225/p37055_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Kroos", "https://assets.laliga.com/squad/2020/t186/p44989/2048x2048/p44989_t186_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Casemiro", "https://assets.laliga.com/squad/2020/t186/p61256/2048x2225/p61256_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Alphonso Davies", "https://img.fcbayern.com/image/upload/t_cms-headshot/f_auto/w_256,h_256,c_fill/cms/public/images/fcbayern-com/players/spielerportraits/ganzkoerper/alphonso_davies_.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Leo Messi", "https://assets.laliga.com/squad/2020/t178/p19054/2048x2225/p19054_t178_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Vinicius Jr", "https://assets.laliga.com/squad/2019/t186/p246333/256x278/p246333_t186_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Martin Ødegaard", "https://assets.laliga.com/squad/2019/t188/p184029/128x139/p184029_t188_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Cristiano Ronaldo", "https://pbs.twimg.com/media/DhwSUQKWkAAY7z-.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Robert Lewandowski", "https://www.thesportsdb.com/images/media/player/cutout/iesp3f1578151282.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Kylian Mbappe", "https://s.yimg.com/xe/i/us/sp/v/soccer/wc/players/661231.3.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Neymar Jr", "https://s.yimg.com/xe/i/us/sp/v/soccer/wc/players/372885.3.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Erling Haaland", "https://lh3.googleusercontent.com/proxy/sdj0hvVYRp0c_Q1eK5ul_baz3IYiETWVSxYZ4MrwRdJLARgVoI4kcW7HNghoL3LXdVEnuZsoQ97HmHMLGjJUx0cIQo2uFDBOK5puLwLeFrin");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Lucas Vazquez", "https://assets.laliga.com/squad/2020/t186/p107593/2048x2225/p107593_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Marco Asensio", "https://assets.laliga.com/squad/2020/t186/p174292/2048x2225/p174292_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Pique", "https://assets.laliga.com/squad/2020/t178/p18221/2048x2225/p18221_t178_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Jordi Alba", "https://assets.laliga.com/squad/2020/t178/p52356/2048x2225/p52356_t178_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Iñaki Williams", "https://especial.elcorreo.com/2019/image/athletic/williams.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Griezmann", "https://assets.laliga.com/squad/2020/t178/p76650/2048x2048/p76650_t178_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Robben", "https://b.fssta.com/uploads/application/soccer/headshots/2263.vresize.350.350.medium.69.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Aguero", "https://resources.premierleague.com/premierleague/photos/players/250x250/p37572.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Kane", "https://resources.premierleague.com/premierleague/photos/players/250x250/p78830.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Ibrahimovic", "https://a.espncdn.com/combiner/i?img=/i/headshots/soccer/players/full/11001.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Salah", "https://resources.premierleague.com/premierleague/photos/players/250x250/p118748.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Timo Werner", "https://resources.premierleague.com/premierleague/photos/players/250x250/p165153.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Icardi", "https://1vs1-7f65.kxcdn.com/img/players/players/mauro-icardi-riveiro-nacimento_120369_212-sp-300.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Dybala", "https://vignette.wikia.nocookie.net/fightclubchampfanom/images/4/4f/Paulo_Dybala.png/revision/latest/scale-to-width-down/340?cb=20190620162631");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Joao Felix", "https://assets.laliga.com/squad/2020/t175/p428399/1024x1024/p428399_t175_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Raheem Sterling", "https://resources.premierleague.com/premierleague/photos/players/250x250/p103955.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Sadio Mane", "https://resources.premierleague.com/premierleague/photos/players/250x250/p110979.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Bale", "https://resources.premierleague.com/premierleague/photos/players/250x250/p36903.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Sergio Ramos", "https://assets.laliga.com/squad/2020/t186/p17861/2048x2225/p17861_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Ansu Fati", "https://assets.laliga.com/squad/2020/t178/p465607/2048x2048/p465607_t178_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Coutinho", "https://assets.laliga.com/squad/2020/t178/p84583/1024x1024/p84583_t178_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Iago Aspas", "https://assets.laliga.com/squad/2019/t176/p40270/256x278/p40270_t176_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Take Kubo", "https://assets.laliga.com/squad/2020/t449/p219271/2048x2225/p219271_t449_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Pogba", "https://resources.premierleague.com/premierleague/photos/players/250x250/p74208.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Firmino", "https://resources.premierleague.com/premierleague/photos/players/250x250/p92217.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Kimmich", "https://www.thesportsdb.com/images/media/player/cutout/ukg7cr1578151267.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("KDB", "https://resources.premierleague.com/premierleague/photos/players/250x250/p61366.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Negredo", "https://assets.laliga.com/squad/2020/t1737/p42892/2048x2225/p42892_t1737_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Buffon", "https://juventushungary.hu/wp-content/uploads/2019/09/buffon-356x385.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Keylor Navas", "https://s.yimg.com/xe/i/us/sp/v/soccer/wc/players/373015.2.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Oblak", "https://img-estaticos.atleticodemadrid.com/system/fotos/9625/destacado_600x600/BUSTO_0014_13_OBLAK.png?1601656337");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Alisson Becker", "https://stadium-wikibol.underdog.gs/images/player/360f9f79-5488-412f-90d6-de8d41bf1b13/1568047976.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Ter Stegen", "https://assets.laliga.com/squad/2020/t178/p77318/2048x2048/p77318_t178_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Courtois", "https://assets.laliga.com/squad/2020/t186/p60772/1024x1024/p60772_t186_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Neuer", "https://www.thesportsdb.com/images/media/player/cutout/8frc7e1578151347.png");
        footballPlayers.add(footballPlayer);
//
        footballPlayer = generatePlayer("Jesus Navas", "https://assets.laliga.com/squad/2020/t179/p17740/2048x2225/p17740_t179_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);
//
        footballPlayer = generatePlayer("Gerard Moreno", "https://assets.laliga.com/squad/2019/t449/p93721/256x278/p93721_t449_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Carlos Soler", "https://assets.laliga.com/squad/2020/t191/p224860/1024x1024/p224860_t191_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Luis Suárez", "https://assets.laliga.com/squad/2020/t175/p39336/2048x2048/p39336_t175_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Marcos Llorente", "https://assets.laliga.com/squad/2020/t175/p192364/2048x2048/p192364_t175_2020_1_003_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Pedri", "https://assets.laliga.com/squad/2020/t178/p490541/2048x2225/p490541_t178_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Pulido", "https://assets.laliga.com/squad/2020/t2894/p88925/2048x2225/p88925_t2894_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Raul Garcia", "https://assets.laliga.com/squad/2019/t174/p18498/256x278/p18498_t174_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Vardy", "https://resources.premierleague.com/premierleague/photos/players/250x250/p101668.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Van Dijk", "https://resources.premierleague.com/premierleague/photos/players/250x250/p97032.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Adama Traore", "https://resources.premierleague.com/premierleague/photos/players/250x250/p159533.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Ocampos", "https://assets.laliga.com/squad/2019/t179/p121117/256x278/p121117_t179_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Reus", "https://www.sportball.es/wp-content/uploads/2020/02/Plantilla-del-Borussia-Dortmund-2019-2020-Marco-Reus-450x450.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Sane", "https://platform-static-files.s3.amazonaws.com/premierleague/photos/players/250x250/p182156.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Jadon Sancho", "https://www.ultimateborussia.com/wp-content/uploads/2018/08/jadon-sancho-2019-2020.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Gio Reyna", "https://www.ultimateborussia.com/wp-content/uploads/2020/02/giovanni-reyna-2020-2021.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Inmobile", "https://assets.laliga.com/squad/2019/t173/p155851/256x278/p155851_t173_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Nainggolan", "https://i.ibb.co/M9XfGRr/nainggolan.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Arturo Vidal", "https://static.wikia.nocookie.net/the-football-database/images/b/b3/Vidal_001.png/revision/latest/scale-to-width-down/340?cb=20140608153727");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Memphis Depay", "https://resources.premierleague.com/premierleague/photos/players/250x250/p106824.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Di Maria", "https://b.fssta.com/uploads/application/soccer/headshots/871.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Camavinga", "https://www.wtfoot.com/wp-content/uploads/2020/04/camavinga.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Morata", "https://b.fssta.com/uploads/application/soccer/headshots/881.png");
        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Loren", "https://assets.laliga.com/squad/2019/t185/p432751/256x278/p432751_t185_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
        footballPlayer = generatePlayer("Chimy Avila", "https://assets.laliga.com/squad/2019/t450/p205992/256x278/p205992_t450_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Willian J.", "https://assets.laliga.com/squad/2019/t188/p73314/256x278/p73314_t188_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Oyarzabal", "https://assets.laliga.com/squad/2019/t188/p219000/256x278/p219000_t188_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Parejo", "https://assets.laliga.com/squad/2019/t191/p51952/256x278/p51952_t191_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);
        footballPlayer = generatePlayer("Joaquín", "https://assets.laliga.com/squad/2019/t185/p10316/256x278/p10316_t185_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);
        footballPlayer = generatePlayer("S. Cazorla", "https://assets.laliga.com/squad/2019/t449/p19524/256x278/p19524_t449_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Y. En-Nesyri", "https://assets.laliga.com/squad/2019/t179/p234991/256x278/p234991_t179_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Fekir", "https://assets.laliga.com/squad/2019/t185/p166552/256x278/p166552_t185_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Isak", "https://assets.laliga.com/squad/2019/t188/p219168/256x278/p219168_t188_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Canales", "https://assets.laliga.com/squad/2019/t185/p56448/256x278/p56448_t185_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Lukaku", "https://platform-static-files.s3.amazonaws.com/premierleague/photos/players/250x250/p66749.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Rodrygo Goes", "https://assets.laliga.com/squad/2020/t186/p440077/2048x2225/p440077_t186_2020_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Saúl", "https://assets.laliga.com/squad/2019/t175/p89335/256x278/p89335_t175_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Enes Ünal", "https://assets.laliga.com/squad/2019/t192/p168636/256x278/p168636_t192_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Sergi Guardiola", "https://assets.laliga.com/squad/2019/t192/p89850/256x278/p89850_t192_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
        footballPlayer = generatePlayer("Luuk De Jong", "https://assets.laliga.com/squad/2019/t179/p53041/256x278/p53041_t179_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Toko Ekambi", "https://assets.laliga.com/squad/2019/t449/p193454/256x278/p193454_t449_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("R. Torres", "https://assets.laliga.com/squad/2019/t450/p90402/256x278/p90402_t450_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Machis", "https://assets.laliga.com/squad/2019/t5683/p111133/256x278/p111133_t5683_2019_1_001_000.png");

        footballPlayer = generatePlayer("Correa", "https://assets.laliga.com/squad/2019/t175/p156223/256x278/p156223_t175_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Gameiro", "https://assets.laliga.com/squad/2019/t191/p42779/256x278/p42779_t191_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Antonio Puertas", "https://assets.laliga.com/squad/2019/t5683/p156301/256x278/p156301_t5683_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
        footballPlayer = generatePlayer("Soldado", "https://assets.laliga.com/squad/2019/t5683/p17926/256x278/p17926_t5683_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);

        footballPlayer = generatePlayer("Muniain", "https://assets.laliga.com/squad/2019/t174/p76012/256x278/p76012_t174_2019_1_001_000.png");
        footballPlayers.add(footballPlayer);
//
//        //Mujeres
//        footballPlayer = generatePlayer("Jennifer Hermoso", "https://assets.laliga.com/squad/2019/t9121/p165364/256x278/p165364_t9121_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Asisat Oshoala", "https://assets.laliga.com/squad/2019/t9121/p193629/256x278/p193629_t9121_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Ainize Barea", "https://assets.laliga.com/squad/2019/t15762/p434496/256x278/p434496_t15762_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Oriana Yoselin Altuve", "https://assets.laliga.com/squad/2019/t13321/p459037/256x278/p459037_t13321_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Jade Boho", "https://assets.laliga.com/squad/2019/t14503/p97172/256x278/p97172_t14503_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Nahikari García", "https://assets.laliga.com/squad/2019/t13324/p176169/256x278/p176169_t13324_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Gabriela Antonia", "https://assets.laliga.com/squad/2019/t15762/p459039/256x278/p459039_t15762_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Alexia Putellas", "https://assets.laliga.com/squad/2019/t9121/p165355/256x278/p165355_t9121_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Lucía García", "https://assets.laliga.com/squad/2019/t12034/p206238/256x278/p206238_t12034_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Alba Redondo", "https://assets.laliga.com/squad/2019/t13319/p191675/256x278/p191675_t13319_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Ángela Sosa", "https://assets.laliga.com/squad/2019/t11212/p434288/256x278/p434288_t11212_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Mª Paz Vilas", "https://assets.laliga.com/squad/2019/t13329/p242635/256x278/p242635_t13329_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Eva Navarro", "https://assets.laliga.com/squad/2019/t13319/p454316/256x278/p454316_t13319_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Verónica Charlyn", "https://assets.laliga.com/squad/2019/t11212/p97440/256x278/p97440_t11212_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Ludmila Da Silva", "https://assets.laliga.com/squad/2019/t11212/p428299/256x278/p428299_t11212_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//
//        //De segunda
//        footballPlayer = generatePlayer("Stuani", "https://assets.laliga.com/squad/2019/t2893/p49464/256x278/p49464_t2893_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("L. Suárez", "https://assets.laliga.com/squad/2019/t190/p432838/256x278/p432838_t190_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Stoichkov", "https://assets.laliga.com/squad/2019/t5233/p198524/256x278/p198524_t5233_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Darwin Nuñez", "https://assets.laliga.com/squad/2019/t1564/p447203/256x278/p447203_t1564_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Alex", "https://assets.laliga.com/squad/2019/t1737/p88479/256x278/p88479_t1737_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Ortuño", "https://assets.laliga.com/squad/2019/t187/p59059/256x278/p59059_t187_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);
//        footballPlayer = generatePlayer("Merquelanz", "https://assets.laliga.com/squad/2019/t5741/p201177/256x278/p201177_t5741_2019_1_001_000.png");
//        footballPlayers.add(footballPlayer);

        return footballPlayers;
    }

    private FootballPlayer generatePlayer(String nickname, String image) {
        FootballPlayer footballPlayer = new FootballPlayer();
        footballPlayer.setNickname(nickname);
        footballPlayer.setPhotos(new FootballPhoto());
        footballPlayer.getPhotos().setPhoto(new FootballPhotoSize());
        footballPlayer.getPhotos().getPhoto().setBig(image);
        return footballPlayer;
    }


    public String getRandomAvatar() {

        ArrayList<FootballPlayer> footballPlayers = new ArrayList<>();

        Random r = new Random();
        int low = 0;
        int high = 36;

        int result = r.nextInt(high - low) + low;

        return footballPlayers.get(result).getPhotos().getPhoto().getBig();
    }


}
