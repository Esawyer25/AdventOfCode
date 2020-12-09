package Year2020.Day9;

import java.util.Arrays;
import java.util.List;

class Input {
    static Integer TEST_LOOKBACK = 5;
    static List<Long> TEST_INPUT = Arrays.asList(35L, 20L, 15L, 25L, 47L, 40L, 62L, 55L, 65L, 95L, 102L, 117L, 150L, 182L,
            127L, 219L, 299L, 277L, 309L, 576L);

    static Integer PUZZLE_LOOKBACK = 25;
    static List<Long> PUZZLE_INPUT = Arrays.asList(
            2L, 32L, 10L, 49L, 28L, 42L, 18L, 29L, 17L, 46L, 27L, 24L, 14L, 31L, 21L, 13L, 48L, 1L, 30L, 23L, 50L, 8L,
            36L, 6L, 7L, 3L, 11L, 19L, 4L, 40L, 5L, 9L, 10L, 12L, 15L, 16L, 17L, 20L, 14L, 88L, 18L, 66L, 13L, 21L, 25L,
            22L, 23L, 26L, 28L, 83L, 29L, 24L, 31L, 19L, 34L, 27L, 30L, 33L, 32L, 35L, 38L, 44L, 37L, 50L, 36L, 39L,
            40L, 60L, 59L, 56L, 52L, 43L, 46L, 47L, 48L, 71L, 64L, 49L, 51L, 82L, 89L, 62L, 108L, 123L, 72L, 73L, 79L,
            153L, 75L, 85L, 94L, 83L, 95L, 90L, 91L, 93L, 109L, 99L, 97L, 148L, 100L, 111L, 113L, 124L, 170L, 161L,
            169L, 160L, 162L, 147L, 152L, 178L, 158L, 238L, 182L, 212L, 173L, 181L, 183L, 213L, 190L, 196L, 197L,
            338L, 211L, 299L, 224L, 237L, 271L, 305L, 307L, 344L, 355L, 325L, 386L, 340L, 331L, 418L, 354L, 356L, 364L,
            363L, 371L, 373L, 409L, 387L, 407L, 408L, 568L, 435L, 624L, 659L, 508L, 576L, 612L, 632L, 656L, 665L, 671L,
            685L, 744L, 1034L, 764L, 717L, 729L, 727L, 734L, 758L, 794L, 1031L, 1058L, 815L, 843L, 1067L, 1570L, 1084L,
            1792L, 1321L, 1188L, 1283L, 1288L, 1493L, 1538L, 1405L, 1402L, 1444L, 1446L, 1552L, 1451L, 2041L, 1461L,
            1573L, 1601L, 3034L, 1873L, 2416L, 1658L, 2509L, 2734L, 2272L, 2367L, 4272L, 2471L, 2590L, 2978L, 2944L,
            2898L, 3062L, 2846L, 3102L, 3474L, 2897L, 2912L, 3024L, 3119L, 3259L, 3174L, 3531L, 3930L, 4025L, 4074L,
            5264L, 4639L, 6031L, 4743L, 5730L, 6080L, 5061L, 6283L, 5743L, 5744L, 5758L, 5936L, 5809L, 5921L, 8738L,
            9818L, 8592L, 6650L, 6293L, 8235L, 10575L, 7461L, 7955L, 8713L, 8817L, 12092L, 9382L, 9804L, 11745L, 14156L,
            10804L, 10805L, 11487L, 11664L, 17409L, 11567L, 11730L, 12102L, 12214L, 12943L, 13754L, 16053L, 26858L,
            14248L, 19685L, 15416L, 16174L, 18621L, 19621L, 24316L, 32564L, 19186L, 21291L, 27630L, 38807L, 21609L,
            22292L, 33393L, 23297L, 23669L, 23944L, 23832L, 31787L, 29807L, 26697L, 37423L, 44055L, 29664L, 30422L,
            34602L, 55893L, 37783L, 37807L, 62986L, 54366L, 40477L, 42483L, 42900L, 43901L, 44906L, 60099L, 45589L,
            46966L, 47129L, 47613L, 47776L, 68738L, 56361L, 64409L, 78035L, 75590L, 74323L, 112639L, 65024L, 72385L,
            78260L, 82713L, 78284L, 91030L, 143061L, 128302L, 90259L, 86801L, 121936L, 112153L, 92555L, 182814L,
            111375L, 94742L, 95389L, 112800L, 120770L, 121385L, 129433L, 137409L, 139347L, 143308L, 173673L, 143284L,
            268415L, 156544L, 168543L, 165085L, 177060L, 218561L, 179356L, 181543L, 182190L, 187297L, 279852L, 187944L,
            277579L, 240808L, 232151L, 208189L, 233570L, 242155L, 264693L, 266842L, 280693L, 282631L, 286592L, 299828L,
            308369L, 321629L, 325087L, 345603L, 397917L, 356416L, 367300L, 368840L, 363733L, 651471L, 420867L, 396133L,
            420095L, 440340L, 441759L, 450344L, 472882L, 475725L, 506848L, 531535L, 547535L, 742496L, 569223L, 664785L,
            898835L, 804073L, 646716L, 670690L, 741736L, 723716L, 720149L, 731033L, 1466212L, 1388501L, 1349179L,
            816228L, 923226L, 973294L, 1004417L, 1122441L, 948607L, 979730L, 1398951L, 1038383L, 1079070L, 1116758L,
            1215939L, 1289372L, 1769157L, 2052364L, 1317406L, 1366865L, 2656237L, 1454749L, 1451182L, 2087014L,
            2387562L, 1896520L, 1739454L, 1764835L, 1789522L, 1921901L, 1928337L, 1953024L, 2295009L, 1986990L,
            2018113L, 2117453L, 3319889L, 2195828L, 2332697L, 2505311L, 4552757L, 2684271L, 2768588L, 2772155L,
            2821614L, 2905931L, 3667791L, 3807635L, 3528976L, 4285721L, 3504289L, 3757567L, 3554357L, 4148852L,
            3850238L, 5238628L, 4725179L, 7631110L, 6003463L, 4135566L, 4313281L, 5515717L, 4528525L, 6301131L,
            5189582L, 7081869L, 5452859L, 6410220L, 5593769L, 6579181L, 6434907L, 9039820L, 7033265L, 7286543L,
            7261856L, 7906419L, 7311924L, 7404595L, 11987035L, 8163519L, 12998364L, 8448847L, 8664091L, 10531988L,
            11717876L, 8841806L, 10044242L, 11490713L, 12905693L, 13814815L, 11046628L, 11863079L, 12627034L,
            13696763L, 13014088L, 13468172L, 14319808L, 14691138L, 14548399L, 15925947L, 14716519L, 22997246L,
            15568114L, 17112938L, 16612366L, 18886048L, 17290653L, 24490113L, 24117747L, 19888434L, 31328885L,
            34534355L, 22537341L, 22909707L, 23673662L, 18272118L, 24877167L, 25641122L, 26482260L, 27333896L,
            27787980L, 54270240L, 31494061L, 30116513L, 30284633L, 31829457L, 37179087L, 32180480L, 33725304L,
            33903019L, 36176701L, 52806473L, 38160552L, 40809459L, 41181825L, 45447048L, 41945780L, 64855487L,
            43149285L, 44754378L, 88596333L, 50518289L, 53816156L, 55121876L, 57450409L, 72230413L, 60401146L,
            61610574L, 61945970L, 102515046L, 71885856L, 65905784L, 113039872L, 74534763L, 76986160L, 141841647L,
            126466061L, 116480543L, 81991284L, 83127605L, 114217302L, 85095065L, 119396379L, 129656639L, 196167477L,
            104334445L, 105640165L, 171602419L, 112572285L, 133831826L, 122011720L, 122347116L, 123556544L, 138932130L,
            137791640L, 140440547L, 142891944L, 182626325L, 151520923L, 158977444L, 242126085L, 165118889L, 167086349L,
            222059735L, 263488465L, 204491444L, 272726514L, 218212450L, 209974610L, 262452267L, 216906730L, 227651885L,
            234584005L, 255843546L, 244358836L, 309978293L, 261348184L, 262488674L, 279372677L, 278232187L, 307526896L,
            294412867L, 421466118L, 377060959L, 324096333L, 385298799L, 421398174L, 371577793L, 426551179L, 414466054L,
            745562451L, 426881340L, 513956682L, 451490735L, 444558615L, 472750276L, 462235890L, 478942841L, 500202382L,
            505707020L, 734078075L, 632925977L, 655293146L, 557604864L, 572645054L, 748638752L, 1084416712L,
            1047392031L, 750977673L, 1318207505L, 786043847L, 798459133L, 816136408L, 859024669L, 871439955L,
            878372075L, 1546652602L, 896049350L, 941178731L, 906794505L, 934986166L, 979145223L, 984649861L,
            1005909402L, 1205571031L, 1288219123L, 1130249918L, 1212898010L, 1306243616L, 1557294915L, 1499616425L,
            1614595541L, 2332696449L, 1712185758L, 1802843855L, 1584502980L, 1657483802L, 2065236084L, 1843674530L,
            1749812030L, 1774421425L, 1847973236L, 2436493534L, 2593740764L, 1912703907L, 2541944776L, 1963795084L,
            962710040L, 2136159320L, 2335820949L, 2805860041L, 2343147928L, 2712514435L, 2863538531L, 4942019361L,
            3084119405L, 3296688738L, 3927650908L, 5140363268L, 3760677143L, 4729900084L, 3431905227L, 3618095955L,
            4368162189L, 5055662363L, 6521391672L, 4048863227L, 7378512895L, 3876498991L, 4306943012L, 4299616033L,
            6740037522L, 4848673755L, 4479307248L, 5427267333L, 7345551965L, 5206686459L, 8373924588L, 6912401758L,
            7452281594L, 7173187729L, 15547112317L, 8244661180L, 7050001182L, 7192582370L, 10996608850L, 8097403203L,
            7494594946L, 11728078131L, 8176115024L, 7925362218L, 12167304855L, 8606559045L, 14667782675L, 8778923281L,
            9148289788L, 9327981003L, 9685993707L, 9906574581L, 10633953792L, 12119088217L, 19592568288L, 14085589487L,
            13962402940L, 14365770099L, 15117944588L, 14544596128L, 14687177316L, 14242583552L, 15670709970L,
            23446705956L, 16101477242L, 18810068816L, 35694045530L, 16531921263L, 16704285499L, 32202631233L,
            17385482326L, 17927213069L, 19234555584L, 18476270791L, 19013974710L, 23868977521L, 20540528373L,
            22753042009L, 26081491157L, 28047992427L, 30946869051L, 28787179680L, 30215306098L, 28929760868L,
            54708020240L, 29913293522L, 30344060794L, 31772187212L, 54815846572L, 32633398505L, 45319100943L,
            48734552496L, 33236206762L, 61987493310L, 46524263218L, 35312695395L, 36403483860L, 52968348107L,
            37490245501L, 39554503083L, 56425551951L, 50453821895L, 65635994240L, 101541996393L, 58392053221L,
            57716940548L, 60257354316L, 58843054390L, 103422170002L, 61685480734L, 108991906812L, 72187901588L,
            68548902157L, 79760469980L, 72790709845L, 69639690622L, 70726452263L, 120093512517L, 89371831967L,
            71716179255L, 96660838176L, 113225702423L, 116559994938L, 90008324978L, 122641723483L, 106879373846L,
            108170762443L, 116108993769L, 137477410528L, 117235107611L, 117974294864L, 121942835050L, 162799034823L,
            130234382891L, 131325171356L, 138188592779L, 139275354420L, 140265081412L, 177605826109L, 140366142885L,
            141355869877L, 229636913379L, 207982619842L, 161088011222L, 161724504233L, 186669163154L, 196887698824L,
            255423700390L, 198179087421L, 426524612203L, 215050136289L, 233344101380L, 234083288633L, 324857755933L,
            257601250496L, 261559554247L, 260131427829L, 301989585645L, 268422975670L, 337253841709L, 422647565469L,
            279540435832L, 280631224297L, 494214716462L, 281722012762L, 339534957298L, 537714044719L, 706065048035L,
            420013264534L, 358612203057L, 455780337917L, 448394237669L, 413229223710L, 431523188801L, 818345269016L,
            449133424922L, 621256970060L, 502506264303L, 517732678325L, 562121013474L, 521690982076L, 528554403499L,
            547963411502L, 627035178727L, 560171660129L, 694951236472L, 638152638889L, 562353237059L, 640334215819L,
            698147160355L, 979869173117L, 771841426767L, 778625467591L, 880656613723L, 814392540974L, 861623461379L,
            844752412511L, 949255867126L, 1071857404620L, 997096836424L, 1766808641092L, 1020238942628L, 1065696089827L,
            1392715824013L, 1088726063628L, 1050245385575L, 1076517815001L, 1108135071631L, 1122524897188L,
            1198324299018L, 1556574697851L, 2248569684593L, 1758494640708L, 1578803774078L, 1946352703550L,
            2012716839992L, 1988791685354L, 1593018008565L, 1659144953485L, 1676016002353L, 2142763839816L,
            2211250960816L, 1969494809754L, 2667529837706L, 2105231908055L, 2070484328203L, 2085935032455L,
            2115941475402L, 2126763200576L, 2196861135259L, 2158380457206L, 2199042712189L, 3605734848557L,
            2320849196206L, 3284259331473L, 4200042646170L, 4304274620244L, 3664807687707L, 3171821782643L,
            3252162962050L, 3663502336768L, 3628639763239L, 3775086428887L, 5691669881012L, 3746500330556L,
            4039979137957L, 4055429842209L, 4323624335835L, 4175716236258L, 4156419360658L, 6155920613359L,
            4201876507857L, 5449024097309L, 4285143657782L, 4395903847448L, 4357423169395L, 5492670978849L,
            5573012158256L, 5605108527679L, 6423984744693L, 6800461545882L, 6835324119411L, 6836629470350L,
            6880802725289L, 6915665298818L, 7703481474725L, 7375140093795L, 8031643988338L, 7786479468513L,
            10479414586902L, 8095408980166L, 8412853011604L, 8358295868515L, 8487020165639L, 8681047505230L,
            8642566827177L, 9734167755091L, 8753327016843L, 11996996902949L, 14060032323895L, 13796468024107L,
            11065683137105L, 11178120685935L, 16056187599025L, 13260614215043L, 13716126844700L, 13671953589761L,
            18376734582268L, 16444496999942L, 15011074278984L, 15078621568520L, 24894247530635L, 16144775337028L,
            15881888448679L, 16737975807343L, 20484017068588L, 23450294599791L, 17129586992816L, 17168067670869L,
            17323614332407L, 27130061599111L, 18487494771934L, 31120082356514L, 22243803823040L, 24326297352148L,
            28683027868745L, 28307707678751L, 24438734900978L, 26932567804804L, 28271688494027L, 47889029500769L,
            39449809179962L, 30089695847504L, 46534192847446L, 65018616493585L, 44453675931518L, 33312843007897L,
            34632270108962L, 41494365023017L, 42727820891628L, 34297654663685L, 34453201325223L, 41455884344964L,
            34491682003276L, 49373865422151L, 40731298594974L, 67945113116859L, 68892410832496L, 56541458486725L,
            58772723716249L, 51371302705782L, 52710423395005L, 54528430748482L, 61564837913766L, 87342693503967L,
            92101686313779L, 63402538855401L);
}