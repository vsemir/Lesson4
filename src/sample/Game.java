package sample;

import java.util.Random;

public class Game {

    public Random random = new Random();

    private String message = "";

    private String intro =
            "В одном большом городе, жил один среднестатистический-ничем-не-примечательный паренек. \n" +
            "Из родствеников и близких у него был воспитавший его друг умершего отца (никому не известный, даже отцу).\n" +
            "И вот однажды к нему подходит измученный и израненный путник. И говорит: — Ты — избранный!!!\n" +
            "Но вы очень удивились. Тогда пришелец говорит: — Беги, прячься скорее, ОHИ идут за тобой.\n" +
            "Герой со свистом покидает родные места. Он бежит куда глаза глядят.\n" +
            "Вскоре вы понимаете что забрели в какието котокомбы и путь лишь один идти вперет!\n Удачи!";

    private int hpPlayer;
    private int dmgPlayer;
    private int defPlayer;
    private int hpEnemy;
    private int dmgEnemy;
    private int defEnemy;
    private int point;

    private int hpPlayerDef = 10;

    private int hpEnemyDef = 5;
    private int defPlayerDef = 1;
    private int defEnemyDef = 0;


    String[] roomInfo = {"В стенах сверкают залежи кристаллов, отражая свет как миллион звёзд.",
            "К штукатурке прибито несколько сотен крысиных шкурок. В ржавом ведре лежат крысиные кости.",
            "Мусор, разбросанный вокруг кострища, намекает, что недавно в этой комнате отдыхали искатели приключений.",
            "Здесь ничто не отбрасывает тени, несмотря ни на какие источники света.",
            "С украшенного фреской потолка скалится ухмыляющийся дьявольский череп.",
            "За взломанной потайной дверью виден обвалившийся коридор",
            "Стены и потолок украшают сотни переплетённых костей.",
            "Все поверхности в комнате закопчены каким-то огромным взрывом.",
            "Каждый квадратный сантиметр пола покрыт нечестивыми письменами, написанными кровью.",
            "Корни, проросшие сквозь потолок, скрывают барельеф божества хитрости на стене.",
            "С потолка, покрытого минералами, срываются капли воды, попадающие в подставленное ведро.",
            "На стенах выжжены силуэты кричащих человеческих лиц.",
            "Кто-то небрежно заложил кирпичами вторую дверь в дальнем углу комнаты.",
            "В этой комнате так долго никого не было, что из-за паутины не видно потолка.",
            "Когда-то здесь была галерея, но сейчас на стенах видны лишь контуры от картин и гвозди." };


    public String getRoomInfo() {
        return "Войдя в комнату вы видете, что " + roomInfo[random.nextInt(roomInfo.length)];
    }

    public void battle(){
        while (hpEnemy > 0 && hpPlayer > 0){
            damagePlayer();
            damageEnemy();
        }
        if (hpEnemy <= 0){
            hpEnemy = hpEnemyDef;
            defPlayer = defPlayerDef;
            defEnemy = defEnemyDef;
            point++;
        }
    }

    private  int damagePlayer(){
        if (defEnemy > 0){
            defEnemy -= dmgPlayer;
            return defEnemy;
        }else {
            hpEnemy -= dmgPlayer;
            return hpEnemy;
        }
    }

    private  int damageEnemy(){
        if (defPlayer > 0){
            defPlayer -= dmgEnemy;
            return defPlayer;
        }else {
            hpPlayer -= dmgEnemy;
            return hpPlayer;
        }
    }

    public void expPlayer(){
        if (point % 3 == 0 && point > 1) {
            message = "Поздравляем! Войдя в комнату вы видете перед собой 2 пьедестала на первом меч на втором щит. Чутье подсказывает, что можно взять только один предмет. Какой вы выбирете?";
            int n = random.nextInt(10);
            if (n < 5){
                message =  "Подняв меч вы почувствовали прилив сил, как будто сам Арес дал вам свое благославление! Повернувшись вы не смогли увидеть другой пьедестал.";
                dmgPlayer += 3;
            }else if (n >= 5){
                message = "Подняв щит вы почувствовали прилив сил, как будто сама богиня Диана дала вам свое благославление! Повернувшись вы не смогли увидеть другой пьедестал.";
                defPlayerDef += 2;
                defPlayer = defPlayerDef;
            }
        }
        if (point % 6 == 0 && point > 1){
            message = "Войдя в комнату вы обнаружили фонтан, чей источник так завораживающе манил вас и войдя в него, вы почувствовали как раны и ушибы прошли, и мышцы укрепились.";
            hpPlayerDef += 5;
            hpPlayer = hpPlayerDef;
        }
        if (point % 10 == 0 && point > 1){
            message = "В комнате стоял стойкий запах смрада. Похоже чем глубже идти, тем сильнее противник.";
            hpEnemyDef += random.nextInt(10);
            defEnemyDef += random.nextInt(5);
            defEnemy = defEnemyDef;
            dmgEnemy += random.nextInt(7);
        }
    }


    public Game() {
        this.hpPlayer = 10;
        this.dmgPlayer = 1;
        this.defPlayer = 1;
        this.hpEnemy = 5;
        this.dmgEnemy = 0;
        this.defEnemy = 0;
        this.point = 0;
    }

    public int getHpPlayer() {
        return hpPlayer;
    }

    public void setHpPlayer(int hpPlayer) {
        this.hpPlayer = hpPlayer;
    }

    public int getDmgPlayer() {
        return dmgPlayer;
    }

    public void setDmgPlayer(int dmgPlayer) {
        this.dmgPlayer = dmgPlayer;
    }

    public int getDefPlayer() {
        return defPlayer;
    }

    public void setDefPlayer(int defPlayer) {
        this.defPlayer = defPlayer;
    }

    public int getHpEnemy() {
        return hpEnemy;
    }

    public void setHpEnemy(int hpEnemy) {
        this.hpEnemy = hpEnemy;
    }

    public int getDmgEnemy() {
        return dmgEnemy;
    }

    public void setDmgEnemy(int dmgEnemy) {
        this.dmgEnemy = dmgEnemy;
    }

    public int getDefEnemy() {
        return defEnemy;
    }

    public void setDefEnemy(int defEnemy) {
        this.defEnemy = defEnemy;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getIntro() {
        return intro;
    }

}
