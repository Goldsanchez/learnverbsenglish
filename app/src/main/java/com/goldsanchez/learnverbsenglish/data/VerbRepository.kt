package com.goldsanchez.learnverbsenglish.data

import com.goldsanchez.learnverbsenglish.domain.model.Verb

interface VerbRepository {
    fun getVerbs(): List<Verb>
}
// cost, cut, deal
class VerbRepositoryImpl : VerbRepository {
    private var irregularVerbs = listOf(
            Verb("be", "was/were", "been", "Ser / Estar",
                "I am a student.", "Yo soy un estudiante.", "soy",
                "He was at home yesterday.", "Él estuvo en casa ayer.", "estuvo",
                "They have been friends for years.", "Ellos han sido amigos por años.", "han sido"),

            Verb("beat", "beat", "beaten", "Golpear / Vencer",
                "The boxer beats his training partner.", "El boxeador golpea a su compañero de entrenamiento.", "golpea",
                "Our team beat theirs in the finals.", "Nuestro equipo venció al suyo en la final.", "venció",
                "She has never been beaten at chess.", "Ella nunca ha sido vencida en ajedrez.", "ha sido vencida"),

            Verb("become", "became", "become", "Llegar a ser / Convertirse en",
                "I want to become a doctor.", "Yo quiero llegar a ser doctor.", "quiero llegar a ser",
                "She became a manager last year.", "Ella se convirtió en gerente el año pasado.", "se convirtió",
                "He has become more patient.", "Él se ha vuelto más paciente.", "se ha vuelto"),

            Verb("begin", "began", "begun", "Comenzar",
                "We begin the class at nine.", "Nosotros comenzamos la clase a las nueve.", "comenzamos",
                "The movie began late.", "La película comenzó tarde.", "comenzó",
                "Winter has begun early this year.", "El invierno ha comenzado temprano este año.", "ha comenzado"),

            Verb("bet", "bet", "bet", "Apostar",
                "I bet on the favorite team.", "Yo apuesto por el equipo favorito.", "apuesto",
                "He bet all his savings.", "Él apostó todos sus ahorros.", "apostó",
                "She has bet on the wrong horse.", "Ella ha apostado por el caballo equivocado.", "ha apostado"),

            Verb("bite", "bit", "bitten", "Morder",
                "The dog bites its toy.", "El perro muerde su juguete.", "muerde",
                "A mosquito bit my arm.", "Un mosquito me mordió el brazo.", "mordió",
                "He has been bitten by a dog.", "Él ha sido mordido por un perro.", "ha sido mordido"),

            Verb("bleed", "bled", "bled", "Sangrar",
                "My finger bleeds when I cut it.", "Mi dedo sangra cuando me lo corto.", "sangra",
                "The wound bled for a while.", "La herida sangró por un rato.", "sangró",
                "He has bled enough from that injury.", "Él ha sangrado suficiente por esa herida.", "ha sangrado"),

            Verb("blow", "blew", "blown", "Soplar / Explotar",
                "The wind blows the leaves.", "El viento sopla las hojas.", "sopla",
                "She blew the dust off the book.", "Ella sopló el polvo del libro.", "sopló",
                "The storm has blown down the tree.", "La tormenta ha derribado el árbol.", "ha derribado"),

            Verb("break", "broke", "broken", "Romper",
                "I sometimes break a glass.", "Yo a veces rompo un vaso.", "rompo",
                "He broke the window accidentally.", "Él rompió la ventana accidentalmente.", "rompió",
                "My phone has broken again.", "Mi teléfono se ha roto otra vez.", "se ha roto"),

            Verb("bring", "brought", "brought", "Traer",
                "I bring my lunch to work.", "Yo traigo mi almuerzo al trabajo.", "traigo",
                "She brought flowers to the party.", "Ella trajo flores a la fiesta.", "trajo",
                "They have brought good news.", "Ellos han traído buenas noticias.", "han traído"),

            Verb("broadcast", "broadcast/broadcasted", "broadcast/broadcasted", "Emitir / Transmitir",
                "The station broadcasts the news at eight.", "La estación emite las noticias a las ocho.", "emite",
                "They broadcast the concert live.", "Ellos emitieron el concierto en vivo.", "emitieron",
                "The show has been broadcast nationally.", "El programa ha sido emitido a nivel nacional.", "ha sido emitido"),

            Verb("build", "built", "built", "Construir",
                "They build houses in this area.", "Ellos construyen casas en esta área.", "construyen",
                "We built a treehouse as kids.", "Nosotros construimos una casa en el árbol cuando éramos niños.", "construimos",
                "The company has built a new factory.", "La compañía ha construido una nueva fábrica.", "ha construido"),

            Verb("burst", "burst", "burst", "Estallar / Reventar",
                "The balloon bursts if you press it.", "El globo revienta si lo aprietas.", "revienta",
                "The pipe burst due to the cold.", "La tubería reventó debido al frío.", "reventó",
                "The dam has burst after the rains.", "La represa ha reventado después de las lluvias.", "ha reventado"),

            Verb("buy", "bought", "bought", "Comprar",
                "I buy groceries every Saturday.", "Yo compro víveres todos los sábados.", "compro",
                "She bought a new car last month.", "Ella compró un coche nuevo el mes pasado.", "compró",
                "We have bought tickets for the concert.", "Nosotros hemos comprado entradas para el concierto.", "hemos comprado"),

            Verb("cast", "cast", "cast", "Lanzar / Emitir (voto)",
                "He casts his fishing line into the river.", "Él lanza su línea de pesca al río.", "lanza",
                "The director cast her in the leading role.", "El director la eligió para el papel principal.", "eligió",
                "The jury has cast its vote.", "El jurado ha emitido su voto.", "ha emitido"),

            Verb("catch", "caught", "caught", "Atrapar / Pillar",
                "The cat catches mice.", "El gato atrapa ratones.", "atrapa",
                "I caught the early bus.", "Yo pillé el autobús temprano.", "pillé",
                "She has caught a bad cold.", "Ella ha pillado un resfriado fuerte.", "ha pillado"),

            Verb("choose", "chose", "chosen", "Elegir",
                "I choose the blue shirt.", "Yo elijo la camisa azul.", "elijo",
                "They chose a new captain.", "Ellos eligieron un nuevo capitán.", "eligieron",
                "He has been chosen for the team.", "Él ha sido elegido para el equipo.", "ha sido elegido"),

            Verb("cling", "clung", "clung", "Aferrarse",
                "The child clings to his mother.", "El niño se aferra a su madre.", "se aferra",
                "The wet clothes clung to her body.", "La ropa mojada se aferró a su cuerpo.", "se aferró",
                "He has clung to that idea for years.", "Él se ha aferrado a esa idea por años.", "se ha aferrado"),

            Verb("come", "came", "come", "Venir",
                "My friends come to visit often.", "Mis amigos vienen a visitar a menudo.", "vienen",
                "She came to the meeting late.", "Ella vino a la reunión tarde.", "vino",
                "Spring has come early.", "La primavera ha llegado temprano.", "ha llegado"),

            Verb("cost", "cost", "cost", "Costar",
                "This book costs twenty dollars.", "Este libro cuesta veinte dólares.", "cuesta",
                "The repairs cost a lot of money.", "Las reparaciones costaron mucho dinero.", "costaron",
                "The project has cost more than expected.", "El proyecto ha costado más de lo esperado.", "ha costado"),

            Verb("creep", "crept", "crept", "Arrastrarse / Moverse sigilosamente",
                "The cat creeps toward the bird.", "El gato se arrastra hacia el pájaro.", "se arrastra",
                "He crept into the room quietly.", "Él se movió sigilosamente a la habitación.", "se movió",
                "A strange feeling has crept over me.", "Un sentimiento extraño se ha apoderado de mí.", "se ha apoderado"),

            Verb("cut", "cut", "cut", "Cortar",
                "She cuts the paper with scissors.", "Ella corta el papel con tijeras.", "corta",
                "I cut my finger while cooking.", "Yo me corté el dedo mientras cocinaba.", "me corté",
                "The electricity has been cut due to maintenance.", "La electricidad ha sido cortada por mantenimiento.", "ha sido cortada"),

            Verb("deal", "dealt", "dealt", "Tratar / Repartir",
                "He deals with customer complaints.", "Él trata las quejas de clientes.", "trata",
                "She dealt the cards for the game.", "Ella repartió las cartas para el juego.", "repartió",
                "We have dealt with this problem before.", "Nosotros hemos tratado este problema antes.", "hemos tratado"),

            Verb("dig", "dug", "dug", "Cavar",
                "The dog digs holes in the garden.", "El perro cava hoyos en el jardín.", "cava",
                "We dug a hole for the tree.", "Nosotros cavamos un hoyo para el árbol.", "cavamos",
                "Archaeologists have dug up ancient ruins.", "Los arqueólogos han desenterrado ruinas antiguas.", "han desenterrado"),

            Verb("do", "did", "done", "Hacer",
                "I do my homework every night.", "Yo hago mi tarea todas las noches.", "hago",
                "She did the laundry yesterday.", "Ella hizo la lavadora ayer.", "hizo",
                "They have done a great job.", "Ellos han hecho un gran trabajo.", "han hecho"),

            Verb("draw", "drew", "drawn", "Dibujar",
                "He draws pictures of animals.", "Él dibuja imágenes de animales.", "dibuja",
                "The child drew a house and a sun.", "El niño dibujó una casa y un sol.", "dibujó",
                "The plans have been drawn by the architect.", "Los planos han sido dibujados por el arquitecto.", "han sido dibujados"),

            Verb("dream", "dreamt/dreamed", "dreamt/dreamed", "Soñar",
                "I often dream about traveling.", "Yo a menudo sueño con viajar.", "sueño",
                "She dreamt of becoming a singer.", "Ella soñó con llegar a ser cantante.", "soñó",
                "He has never dreamt of such success.", "Él nunca ha soñado con tanto éxito.", "ha soñado"),

            Verb("drink", "drank", "drunk", "Beber",
                "We drink coffee in the morning.", "Nosotros bebemos café por la mañana.", "bebemos",
                "He drank two glasses of water.", "Él bebió dos vasos de agua.", "bebió",
                "She has drunk all the juice.", "Ella ha bebido todo el jugo.", "ha bebido"),

            Verb("drive", "drove", "driven", "Conducir",
                "I drive to work every day.", "Yo conduzco al trabajo todos los días.", "conduzco",
                "She drove across the country.", "Ella condujo a través del país.", "condujo",
                "He has never driven a truck.", "Él nunca ha conducido un camión.", "ha conducido"),

            Verb("eat", "ate", "eaten", "Comer",
                "We eat dinner at seven o'clock.", "Nosotros cenamos a las siete en punto.", "cenamos",
                "The cat ate its food quickly.", "El gato comió su comida rápidamente.", "comió",
                "They have already eaten lunch.", "Ellos ya han almorzado.", "han almorzado"),

            Verb("fall", "fell", "fallen", "Caer",
                "Leaves fall from the trees in autumn.", "Las hojas caen de los árboles en otoño.", "caen",
                "He fell off his bicycle.", "Él se cayó de su bicicleta.", "se cayó",
                "The price has fallen significantly.", "El precio ha caído significativamente.", "ha caído"),

            Verb("feed", "fed", "fed", "Alimentar",
                "I feed the birds in my garden.", "Yo alimento a los pájaros en mi jardín.", "alimento",
                "She fed the baby at six.", "Ella alimentó al bebé a las seis.", "alimentó",
                "They have fed the animals already.", "Ellos ya han alimentado a los animales.", "han alimentado"),

            Verb("feel", "felt", "felt", "Sentir",
                "I feel happy today.", "Yo me siento feliz hoy.", "me siento",
                "She felt a sharp pain.", "Ella sintió un dolor agudo.", "sintió",
                "We have felt the cold weather arrive.", "Nosotros hemos sentido llegar el clima frío.", "hemos sentido"),

            Verb("fight", "fought", "fought", "Pelear / Luchar",
                "They fight for their rights.", "Ellos luchan por sus derechos.", "luchan",
                "The soldiers fought bravely.", "Los soldados lucharon valientemente.", "lucharon",
                "She has fought against the disease.", "Ella ha luchado contra la enfermedad.", "ha luchado"),

            Verb("find", "found", "found", "Encontrar",
                "I find my keys on the table.", "Yo encuentro mis llaves en la mesa.", "encuentro",
                "He found a wallet on the street.", "Él encontró una cartera en la calle.", "encontró",
                "They have found the solution.", "Ellos han encontrado la solución.", "han encontrado"),

            Verb("flee", "fled", "fled", "Huir",
                "People flee from dangerous situations.", "La gente huye de situaciones peligrosas.", "huye",
                "The birds fled when the cat appeared.", "Los pájaros huyeron cuando el gato apareció.", "huyeron",
                "Many have fled the conflict zone.", "Muchos han huido de la zona de conflicto.", "han huido"),

            Verb("fling", "flung", "flung", "Lanzar con fuerza",
                "He flings the ball to his teammate.", "Él lanza la pelota a su compañero de equipo.", "lanza",
                "She flung the door open angrily.", "Ella abrió la puerta de golpe con enojo.", "abrió",
                "The machine has flung out the defective part.", "La máquina ha expulsado la pieza defectuosa.", "ha expulsado"),

            Verb("fly", "flew", "flown", "Volar",
                "Birds fly south for the winter.", "Los pájaros vuelan al sur para el invierno.", "vuelan",
                "She flew to Paris for a conference.", "Ella voló a París para una conferencia.", "voló",
                "Time has flown by this year.", "El tiempo ha volado este año.", "ha volado"),

            Verb("forget", "forgot", "forgotten", "Olvidar",
                "I sometimes forget my password.", "Yo a veces olvido mi contraseña.", "olvido",
                "He forgot to buy milk.", "Él olvidó comprar leche.", "olvidó",
                "She has forgotten her appointment.", "Ella ha olvidado su cita.", "ha olvidado"),

            Verb("forgive", "forgave", "forgiven", "Perdonar",
                "I forgive small mistakes.", "Yo perdono los errores pequeños.", "perdono",
                "She forgave him for his honesty.", "Ella lo perdonó por su honestidad.", "perdonó",
                "He has been forgiven by his friend.", "Él ha sido perdonado por su amigo.", "ha sido perdonado"),

            Verb("freeze", "froze", "frozen", "Congelar",
                "Water freezes at zero degrees.", "El agua se congela a cero grados.", "se congela",
                "The lake froze completely last winter.", "El lago se congeló completamente el invierno pasado.", "se congeló",
                "The pipes have frozen due to the cold.", "Las tuberías se han congelado debido al frío.", "se han congelado"),

            Verb("get", "got", "gotten/got", "Obtener / Recibir",
                "I get a newspaper every morning.", "Yo recibo un periódico cada mañana.", "recibo",
                "She got a promotion at work.", "Ella obtuvo un ascenso en el trabajo.", "obtuvo",
                "They have gotten permission to leave.", "Ellos han obtenido permiso para salir.", "han obtenido"),

            Verb("give", "gave", "given", "Dar",
                "He gives money to charity.", "Él da dinero a la caridad.", "da",
                "I gave her a book for her birthday.", "Yo le di un libro para su cumpleaños.", "di",
                "The teacher has given us homework.", "El profesor nos ha dado tarea.", "ha dado"),

            Verb("go", "went", "gone", "Ir",
                "We go to the cinema on Fridays.", "Nosotros vamos al cine los viernes.", "vamos",
                "She went to the market this morning.", "Ella fue al mercado esta mañana.", "fue",
                "He has gone to the doctor's office.", "Él ha ido al consultorio del médico.", "ha ido"),

            Verb("grind", "ground", "ground", "Moler",
                "I grind coffee beans fresh each day.", "Yo muelo granos de café frescos cada día.", "muelo",
                "She ground the spices for the curry.", "Ella molió las especias para el curry.", "molió",
                "The pepper has been ground finely.", "La pimienta ha sido molida finamente.", "ha sido molida"),

            Verb("grow", "grew", "grown", "Crecer / Cultivar",
                "Plants grow with water and sunlight.", "Las plantas crecen con agua y luz solar.", "crecen",
                "He grew vegetables in his backyard.", "Él cultivó vegetales en su patio trasero.", "cultivó",
                "The company has grown rapidly.", "La compañía ha crecido rápidamente.", "ha crecido"),

            Verb("hang", "hung", "hung", "Colgar",
                "I hang my coat on the hook.", "Yo cuelgo mi abrigo en el gancho.", "cuelgo",
                "She hung the painting on the wall.", "Ella colgó la pintura en la pared.", "colgó",
                "The clothes have been hung to dry.", "La ropa ha sido colgada para secar.", "ha sido colgada"),

            Verb("have", "had", "had", "Tener",
                "I have two sisters.", "Yo tengo dos hermanas.", "tengo",
                "She had a meeting at ten.", "Ella tuvo una reunión a las diez.", "tuvo",
                "They have had good luck recently.", "Ellos han tenido buena suerte recientemente.", "han tenido"),

            Verb("hear", "heard", "heard", "Oír",
                "We hear the birds singing.", "Nosotros oímos a los pájaros cantar.", "oímos",
                "I heard a strange noise last night.", "Yo oí un ruido extraño anoche.", "oí",
                "She has heard that song before.", "Ella ha oído esa canción antes.", "ha oído"),

            Verb("hide", "hid", "hidden", "Esconder",
                "Children hide during games.", "Los niños se esconden durante los juegos.", "se esconden",
                "He hid the present under the bed.", "Él escondió el regalo debajo de la cama.", "escondió",
                "The treasure has been hidden for centuries.", "El tesoro ha estado escondido por siglos.", "ha estado escondido"),

            Verb("hit", "hit", "hit", "Golpear / Alcanzar",
                "The boxer hits the punching bag.", "El boxeador golpea el saco de boxeo.", "golpea",
                "The ball hit the window.", "La pelota golpeó la ventana.", "golpeó",
                "The song has hit number one on the charts.", "La canción ha alcanzado el número uno en las listas.", "ha alcanzado"),

            Verb("hold", "held", "held", "Sostener",
                "She holds her baby carefully.", "Ella sostiene a su bebé con cuidado.", "sostiene",
                "They held a party last weekend.", "Ellos celebraron una fiesta el fin de semana pasado.", "celebraron",
                "The stadium has held many concerts.", "El estadio ha albergado muchos conciertos.", "ha albergado"),

            Verb("hurt", "hurt", "hurt", "Doler / Lastimar",
                "My back hurts after work.", "Mi espalda me duele después del trabajo.", "me duele",
                "He hurt his ankle playing soccer.", "Él se lastimó el tobillo jugando fútbol.", "se lastimó",
                "Her feelings have been hurt by the comment.", "Sus sentimientos han sido heridos por el comentario.", "han sido heridos"),

            Verb("keep", "kept", "kept", "Mantener / Guardar",
                "I keep old letters in a box.", "Yo guardo cartas viejas en una caja.", "guardo",
                "She kept her promise.", "Ella cumplió su promesa.", "cumplió",
                "They have kept the secret for a long time.", "Ellos han guardado el secreto por mucho tiempo.", "han guardado"),

            Verb("kneel", "knelt/kneeled", "knelt/kneeled", "Arrodillarse",
                "People kneel to pray in church.", "La gente se arrodilla para rezar en la iglesia.", "se arrodilla",
                "He knelt to tie his shoelaces.", "Él se arrodilló para atar sus cordones.", "se arrodilló",
                "She has knelt in that spot many times.", "Ella se ha arrodillado en ese lugar muchas veces.", "se ha arrodillado"),

            Verb("know", "knew", "known", "Saber / Conocer",
                "I know the answer to that question.", "Yo sé la respuesta a esa pregunta.", "sé",
                "She knew the truth all along.", "Ella supo la verdad todo el tiempo.", "supo",
                "We have known each other since childhood.", "Nosotros nos conocemos desde la infancia.", "nos conocemos"),

            Verb("lay", "laid", "laid", "Poner (colocar)",
                "The hen lays an egg every morning.", "La gallina pone un huevo cada mañana.", "pone",
                "I laid the book on the shelf.", "Yo puse el libro en el estante.", "puse",
                "The workers have laid the foundation.", "Los trabajadores han puesto los cimientos.", "han puesto"),

            Verb("lead", "led", "led", "Guiar / Conducir",
                "She leads the research team.", "Ella guía al equipo de investigación.", "guía",
                "The path led us to a beautiful lake.", "El camino nos condujo a un lago hermoso.", "nos condujo",
                "His actions have led to positive changes.", "Sus acciones han conducido a cambios positivos.", "han conducido"),

            Verb("lean", "leant/leaned", "leant/leaned", "Inclinarse",
                "He leans against the wall when he waits.", "Él se inclina contra la pared cuando espera.", "se inclina",
                "She leant out of the window.", "Ella se inclinó por la ventana.", "se inclinó",
                "The tower has leaned for centuries.", "La torre se ha inclinado durante siglos.", "se ha inclinado"),

            Verb("leap", "leapt/leaped", "leapt/leaped", "Saltar",
                "The frog leaps from one leaf to another.", "La rana salta de una hoja a otra.", "salta",
                "He leapt over the small fence.", "Él saltó por encima de la pequeña valla.", "saltó",
                "Her heart has leapt with joy.", "Su corazón ha dado un brinco de alegría.", "ha dado un brinco"),

            Verb("learn", "learnt/learned", "learnt/learned", "Aprender",
                "I learn new words every day.", "Yo aprendo nuevas palabras cada día.", "aprendo",
                "She learnt to play the guitar.", "Ella aprendió a tocar la guitarra.", "aprendió",
                "They have learned from their mistakes.", "Ellos han aprendido de sus errores.", "han aprendido"),

            Verb("leave", "left", "left", "Dejar / Salir",
                "We leave the house at eight.", "Nosotros salimos de la casa a las ocho.", "salimos",
                "He left his umbrella on the bus.", "Él dejó su paraguas en el autobús.", "dejó",
                "The train has already left the station.", "El tren ya ha salido de la estación.", "ha salido"),

            Verb("lend", "lent", "lent", "Prestar",
                "I sometimes lend money to my brother.", "Yo a veces le presto dinero a mi hermano.", "presto",
                "She lent me her car for the weekend.", "Ella me prestó su coche para el fin de semana.", "prestó",
                "The library has lent me this book.", "La biblioteca me ha prestado este libro.", "me ha prestado"),

            Verb("let", "let", "let", "Permitir",
                "My parents let me stay out late.", "Mis padres me permiten quedarme fuera hasta tarde.", "me permiten",
                "She let the dog into the garden.", "Ella permitió al perro entrar al jardín.", "permitió",
                "The manager has let us leave early.", "El gerente nos ha permitido salir temprano.", "nos ha permitido"),

            Verb("lie", "lay", "lain", "Estar tumbado",
                "I lie on the sofa to read.", "Yo me tumbo en el sofá para leer.", "me tumbo",
                "The cat lay in the sun all afternoon.", "El gato estuvo tumbado al sol toda la tarde.", "estuvo tumbado",
                "The book has lain on that table for days.", "El libro ha estado sobre esa mesa por días.", "ha estado"),

            Verb("light", "lit", "lit", "Encender",
                "He lights the candles for dinner.", "Él enciende las velas para la cena.", "enciende",
                "She lit the fire with a match.", "Ella encendió el fuego con un fósforo.", "encendió",
                "The streets have been lit for the festival.", "Las calles han sido iluminadas para el festival.", "han sido iluminadas"),

            Verb("lose", "lost", "lost", "Perder",
                "I often lose my pen.", "Yo a menudo pierdo mi bolígrafo.", "pierdo",
                "He lost his job during the crisis.", "Él perdió su trabajo durante la crisis.", "perdió",
                "They have lost their way in the forest.", "Ellos han perdido su camino en el bosque.", "han perdido"),

            Verb("make", "made", "made", "Hacer",
                "She makes her own bread.", "Ella hace su propio pan.", "hace",
                "We made a sandcastle at the beach.", "Nosotros hicimos un castillo de arena en la playa.", "hicimos",
                "He has made a difficult decision.", "Él ha tomado una decisión difícil.", "ha tomado"),

            Verb("mean", "meant", "meant", "Significar",
                "This word means something different.", "Esta palabra significa algo diferente.", "significa",
                "I meant to call you yesterday.", "Yo tuve la intención de llamarte ayer.", "tuve la intención",
                "Her silence has meant agreement.", "Su silencio ha significado acuerdo.", "ha significado"),

            Verb("meet", "met", "met", "Conocer / Encontrarse",
                "I meet my friends for coffee.", "Yo me reúno con mis amigos para tomar café.", "me reúno",
                "She met her husband at university.", "Ella conoció a su esposo en la universidad.", "conoció",
                "They have met the new neighbors.", "Ellos han conocido a los nuevos vecinos.", "han conocido"),

            Verb("misunderstand", "misunderstood", "misunderstood", "Malinterpretar",
                "People sometimes misunderstand my accent.", "La gente a veces malinterpreta mi acento.", "malinterpreta",
                "He misunderstood the instructions.", "Él malinterpretó las instrucciones.", "malinterpretó",
                "I have been misunderstood on many occasions.", "Yo he sido malinterpretado en muchas ocasiones.", "he sido malinterpretado"),

            Verb("overcome", "overcame", "overcome", "Superar",
                "She overcomes obstacles with determination.", "Ella supera obstáculos con determinación.", "supera",
                "He overcame his fear of public speaking.", "Él superó su miedo a hablar en público.", "superó",
                "They have overcome many challenges.", "Ellos han superado muchos desafíos.", "han superado"),

            Verb("pay", "paid", "paid", "Pagar",
                "I pay the bills online.", "Yo pago las facturas en línea.", "pago",
                "She paid for dinner last night.", "Ella pagó la cena anoche.", "pagó",
                "We have paid the rent for this month.", "Nosotros hemos pagado el alquiler de este mes.", "hemos pagado"),

            Verb("put", "put", "put", "Poner",
                "He puts sugar in his coffee.", "Él pone azúcar en su café.", "pone",
                "I put the keys in my pocket.", "Yo puse las llaves en mi bolsillo.", "puse",
                "She has put the flowers in a vase.", "Ella ha puesto las flores en un jarrón.", "ha puesto"),

            Verb("read", "read", "read", "Leer",
                "I read the newspaper every morning.", "Yo leo el periódico cada mañana.", "leo",
                "She read the entire book in one day.", "Ella leyó el libro completo en un día.", "leyó",
                "He has read that article already.", "Él ya ha leído ese artículo.", "ha leído"),

            Verb("ride", "rode", "ridden", "Montar",
                "We ride our bicycles in the park.", "Nosotros montamos nuestras bicicletas en el parque.", "montamos",
                "She rode a horse on the beach.", "Ella montó a caballo en la playa.", "montó",
                "He has never ridden a motorcycle.", "Él nunca ha montado en motocicleta.", "ha montado"),

            Verb("ring", "rang", "rung", "Sonar",
                "The doorbell rings when someone arrives.", "El timbre suena cuando alguien llega.", "suena",
                "He rang the bell three times.", "Él hizo sonar la campana tres veces.", "hizo sonar",
                "The alarm has rung for five minutes.", "La alarma ha sonado por cinco minutos.", "ha sonado"),

            Verb("rise", "rose", "risen", "Elevarse",
                "The sun rises in the east.", "El sol se eleva por el este.", "se eleva",
                "Prices rose after the announcement.", "Los precios se elevaron después del anuncio.", "se elevaron",
                "The moon has risen over the mountains.", "La luna se ha elevado sobre las montañas.", "se ha elevado"),

            Verb("run", "ran", "run", "Correr",
                "I run for thirty minutes each day.", "Yo corro por treinta minutos cada día.", "corro",
                "She ran to catch the bus.", "Ella corrió para alcanzar el autobús.", "corrió",
                "The engine has run smoothly all week.", "El motor ha funcionado suavemente toda la semana.", "ha funcionado"),

            Verb("say", "said", "said", "Decir",
                "He says hello to everyone.", "Él dice hola a todos.", "dice",
                "I said the answer clearly.", "Yo dije la respuesta claramente.", "dije",
                "They have said they will help us.", "Ellos han dicho que nos ayudarán.", "han dicho"),

            Verb("see", "saw", "seen", "Ver",
                "We see our grandparents every Sunday.", "Nosotros vemos a nuestros abuelos cada domingo.", "vemos",
                "She saw a shooting star last night.", "Ella vio una estrella fugaz anoche.", "vio",
                "I have seen that movie before.", "Yo he visto esa película antes.", "he visto"),

            Verb("seek", "sought", "sought", "Buscar (procurar)",
                "They seek advice from experts.", "Ellos buscan consejo de expertos.", "buscan",
                "He sought permission to leave early.", "Él buscó permiso para salir temprano.", "buscó",
                "She has sought a solution to the problem.", "Ella ha buscado una solución al problema.", "ha buscado"),

            Verb("sell", "sold", "sold", "Vender",
                "I sell old books online.", "Yo vendo libros viejos en línea.", "vendo",
                "She sold her car last week.", "Ella vendió su coche la semana pasada.", "vendió",
                "They have sold their house.", "Ellos han vendido su casa.", "han vendido"),

            Verb("send", "sent", "sent", "Enviar",
                "He sends emails to his colleagues.", "Él envía correos electrónicos a sus colegas.", "envía",
                "I sent a package to my friend.", "Yo envié un paquete a mi amigo.", "envié",
                "The company has sent the documents.", "La compañía ha enviado los documentos.", "ha enviado"),

            Verb("set", "set", "set", "Establecer / Poner (hora)",
                "She sets the alarm for six o'clock.", "Ella pone la alarma para las seis en punto.", "pone",
                "We set the table for dinner.", "Nosotros pusimos la mesa para la cena.", "pusimos",
                "The sun has set behind the hills.", "El sol se ha puesto detrás de las colinas.", "se ha puesto"),

            Verb("shake", "shook", "shaken", "Sacudir",
                "The dog shakes water from its fur.", "El perro sacude el agua de su pelaje.", "sacude",
                "She shook the bottle before opening.", "Ella sacudió la botella antes de abrirla.", "sacudió",
                "The earthquake has shaken the buildings.", "El terremoto ha sacudido los edificios.", "ha sacudido"),

            Verb("shine", "shone", "shone", "Brillar",
                "The sun shines brightly in summer.", "El sol brilla intensamente en verano.", "brilla",
                "Her eyes shone with excitement.", "Sus ojos brillaron con emoción.", "brillaron",
                "The moon has shone all night.", "La luna ha brillado toda la noche.", "ha brillado"),

            Verb("shoot", "shot", "shot", "Disparar / Fotografiar",
                "The hunter shoots accurately.", "El cazador dispara con precisión.", "dispara",
                "He shot a documentary in Africa.", "Él filmó un documental en África.", "filmó",
                "The photographer has shot many celebrities.", "El fotógrafo ha fotografiado a muchas celebridades.", "ha fotografiado"),

            Verb("show", "showed", "shown/showed", "Mostrar",
                "He shows his passport at the airport.", "Él muestra su pasaporte en el aeropuerto.", "muestra",
                "She showed me her new apartment.", "Ella me mostró su nuevo apartamento.", "me mostró",
                "The data has shown positive results.", "Los datos han mostrado resultados positivos.", "han mostrado"),

            Verb("shut", "shut", "shut", "Cerrar",
                "I shut the windows before leaving.", "Yo cierro las ventanas antes de salir.", "cierro",
                "She shut the book after reading.", "Ella cerró el libro después de leer.", "cerró",
                "The store has shut early today.", "La tienda ha cerrado temprano hoy.", "ha cerrado"),

            Verb("sing", "sang", "sung", "Cantar",
                "Birds sing at dawn.", "Los pájaros cantan al amanecer.", "cantan",
                "She sang a song for the audience.", "Ella cantó una canción para el público.", "cantó",
                "The choir has sung at many events.", "El coro ha cantado en muchos eventos.", "ha cantado"),

            Verb("sink", "sank", "sunk", "Hundirse",
                "Heavy objects sink in water.", "Los objetos pesados se hunden en el agua.", "se hunden",
                "The ship sank during the storm.", "El barco se hundió durante la tormenta.", "se hundió",
                "The sun has sunk below the horizon.", "El sol se ha hundido bajo el horizonte.", "se ha hundido"),

            Verb("sit", "sat", "sat", "Sentarse",
                "We sit at the same table every day.", "Nosotros nos sentamos en la misma mesa todos los días.", "nos sentamos",
                "He sat next to me in class.", "Él se sentó junto a mí en clase.", "se sentó",
                "The cat has sat on that chair all afternoon.", "El gato se ha sentado en esa silla toda la tarde.", "se ha sentado"),

            Verb("sleep", "slept", "slept", "Dormir",
                "I sleep eight hours each night.", "Yo duermo ocho horas cada noche.", "duermo",
                "The baby slept through the night.", "El bebé durmió toda la noche.", "durmió",
                "They have slept in that hotel before.", "Ellos han dormido en ese hotel antes.", "han dormido"),

            Verb("slide", "slid", "slid", "Deslizar",
                "Children slide on the ice.", "Los niños se deslizan sobre el hielo.", "se deslizan",
                "The door slid open automatically.", "La puerta se deslizó abierta automáticamente.", "se deslizó",
                "The car has slid on the wet road.", "El coche se ha deslizado en la carretera mojada.", "se ha deslizado"),

            Verb("smell", "smelt/smelled", "smelt/smelled", "Oler",
                "Flowers smell wonderful in spring.", "Las flores huelen maravilloso en primavera.", "huelen",
                "I smelt smoke in the kitchen.", "Yo olí humo en la cocina.", "olí",
                "The bread has smelled delicious all morning.", "El pan ha olido delicioso toda la mañana.", "ha olido"),

            Verb("speak", "spoke", "spoken", "Hablar",
                "She speaks three languages.", "Ella habla tres idiomas.", "habla",
                "He spoke to the manager about the issue.", "Él habló con el gerente sobre el asunto.", "habló",
                "English is spoken in many countries.", "El inglés se habla en muchos países.", "se habla"),

            Verb("spell", "spelt/spelled", "spelt/spelled", "Deletrear",
                "I spell my name for them.", "Yo deletreo mi nombre para ellos.", "deletreo",
                "She spelt the word correctly.", "Ella deletreó la palabra correctamente.", "deletreó",
                "The name has been spelt wrong on the document.", "El nombre ha sido deletreado mal en el documento.", "ha sido deletreado"),

            Verb("spend", "spent", "spent", "Gastar / Pasar (tiempo)",
                "We spend our vacations at the beach.", "Nosotros pasamos nuestras vacaciones en la playa.", "pasamos",
                "He spent a lot of money on that car.", "Él gastó mucho dinero en ese coche.", "gastó",
                "I have spent years studying this topic.", "Yo he pasado años estudiando este tema.", "he pasado"),

            Verb("spill", "spilt/spilled", "spilt/spilled", "Derramar",
                "She sometimes spills coffee on her desk.", "Ella a veces derrama café en su escritorio.", "derrama",
                "I spilt milk on the floor.", "Yo derramé leche en el suelo.", "derramé",
                "The water has spilled from the glass.", "El agua se ha derramado del vaso.", "se ha derramado"),

            Verb("spin", "spun", "spun", "Girar",
                "The Earth spins on its axis.", "La Tierra gira sobre su eje.", "gira",
                "She spun the wheel quickly.", "Ella giró la rueda rápidamente.", "giró",
                "The dancer has spun around many times.", "La bailarina ha girado muchas veces.", "ha girado"),

            Verb("spit", "spat", "spat", "Escupir",
                "The llama spits when it is angry.", "La llama escupe cuando está enojada.", "escupe",
                "He spat out the bad-tasting food.", "Él escupió la comida que sabía mal.", "escupió",
                "The child has spat his medicine out.", "El niño ha escupido su medicina.", "ha escupido"),

            Verb("split", "split", "split", "Dividir",
                "We split the bill at the restaurant.", "Nosotros dividimos la cuenta en el restaurante.", "dividimos",
                "He split the wood for the fire.", "Él partió la leña para el fuego.", "partió",
                "The group has split into two teams.", "El grupo se ha dividido en dos equipos.", "se ha dividido"),

            Verb("spoil", "spoilt/spoiled", "spoilt/spoiled", "Estropear / Mimara",
                "Heat spoils milk quickly.", "El calor estropea la leche rápidamente.", "estropea",
                "She spoilt the surprise by telling him.", "Ella estropeó la sorpresa contándoselo.", "estropeó",
                "The grandparents have spoiled their grandchildren.", "Los abuelos han mimado a sus nietos.", "han mimado"),

            Verb("spread", "spread", "spread", "Extender",
                "She spreads butter on the toast.", "Ella extiende mantequilla sobre la tostada.", "extiende",
                "The news spread rapidly.", "Las noticias se extendieron rápidamente.", "se extendieron",
                "The virus has spread to other countries.", "El virus se ha extendido a otros países.", "se ha extendido"),

            Verb("spring", "sprang", "sprung", "Saltar / Brotar",
                "The cat springs onto the couch.", "El gato salta al sofá.", "salta",
                "He sprang out of his chair in surprise.", "Él saltó de su silla por la sorpresa.", "saltó",
                "New leaves have sprung on the trees.", "Nuevas hojas han brotado en los árboles.", "han brotado"),

            Verb("stand", "stood", "stood", "Estar de pie",
                "We stand in line for the bus.", "Nosotros estamos de pie en la fila para el autobús.", "estamos de pie",
                "He stood near the door waiting.", "Él estuvo de pie cerca de la puerta esperando.", "estuvo de pie",
                "The old building has stood for a hundred years.", "El edificio viejo ha estado de pie por cien años.", "ha estado de pie"),

            Verb("steal", "stole", "stolen", "Robar",
                "Thieves steal from unattended cars.", "Los ladrones roban de coches desatendidos.", "roban",
                "Someone stole my bicycle.", "Alguien robó mi bicicleta.", "robó",
                "The jewels have been stolen from the museum.", "Las joyas han sido robadas del museo.", "han sido robadas"),

            Verb("stick", "stuck", "stuck", "Pegar / Atascarse",
                "I stick the poster to the wall with tape.", "Yo pego el póster a la pared con cinta.", "pego",
                "The car stuck in the mud.", "El coche se atascó en el barro.", "se atascó",
                "The key has stuck in the lock.", "La llave se ha atascado en la cerradura.", "se ha atascado"),

            Verb("sting", "stung", "stung", "Picar",
                "Bees sting when they feel threatened.", "Las abejas pican cuando se sienten amenazadas.", "pican",
                "A jellyfish stung my leg.", "Una medusa me picó la pierna.", "me picó",
                "My arm has stung since the insect bite.", "Mi brazo me ha picado desde la picadura de insecto.", "me ha picado"),

            Verb("strike", "struck", "struck", "Golpear / Atacar",
                "Lightning strikes tall objects.", "Los rayos golpean objetos altos.", "golpean",
                "The clock struck twelve.", "El reloj dio las doce.", "dio",
                "The workers have struck for higher wages.", "Los trabajadores se han declarado en huelga por salarios más altos.", "se han declarado en huelga"),

            Verb("swear", "swore", "sworn", "Jurara",
                "Witnesses swear to tell the truth.", "Los testigos juran decir la verdad.", "juran",
                "He swore allegiance to the flag.", "Él juró lealtad a la bandera.", "juró",
                "She has sworn to keep the secret.", "Ella ha jurado guardar el secreto.", "ha jurado"),

            Verb("sweep", "swept", "swept", "Barrer",
                "I sweep the kitchen floor every day.", "Yo barro el suelo de la cocina todos los días.", "barro",
                "She swept the leaves from the patio.", "Ella barrió las hojas del patio.", "barrió",
                "The new trend has swept the nation.", "La nueva tendencia ha arrasado la nación.", "ha arrasado"),

            Verb("swim", "swam", "swum", "Nadar",
                "We swim in the pool during summer.", "Nosotros nadamos en la piscina durante el verano.", "nadamos",
                "She swam across the lake.", "Ella nadó a través del lago.", "nadó",
                "He has swum in the ocean many times.", "Él ha nadado en el océano muchas veces.", "ha nadado"),

            Verb("swing", "swung", "swung", "Balancearse",
                "Children swing on the playground.", "Los niños se balancean en el parque infantil.", "se balancean",
                "He swung the bat and hit the ball.", "Él balanceó el bate y golpeó la pelota.", "balanceó",
                "The pendulum has swung for hours.", "El péndulo se ha balanceado por horas.", "se ha balanceado"),

            Verb("take", "took", "taken", "Tomar",
                "I take a shower every morning.", "Yo tomo una ducha cada mañana.", "tomo",
                "She took the train to the city.", "Ella tomó el tren a la ciudad.", "tomó",
                "He has taken my advice seriously.", "Él ha tomado mi consejo en serio.", "ha tomado"),

            Verb("teach", "taught", "taught", "Enseñar",
                "She teaches mathematics at the school.", "Ella enseña matemáticas en la escuela.", "enseña",
                "My father taught me how to drive.", "Mi padre me enseñó a conducir.", "me enseñó",
                "He has taught English for over ten years.", "Él ha enseñado inglés por más de diez años.", "ha enseñado"),

            Verb("tear", "tore", "torn", "Rasgar",
                "I sometimes tear paper by accident.", "Yo a veces rasgo papel por accidente.", "rasgo",
                "She tore the letter into pieces.", "Ella rompió la carta en pedazos.", "rompió",
                "The page has been torn from the book.", "La página ha sido arrancada del libro.", "ha sido arrancada"),

            Verb("tell", "told", "told", "Contar / Decir",
                "He tells stories to his children.", "Él cuenta historias a sus hijos.", "cuenta",
                "She told me the good news.", "Ella me contó las buenas noticias.", "me contó",
                "I have told you the truth.", "Yo te he dicho la verdad.", "te he dicho"),

            Verb("think", "thought", "thought", "Pensar",
                "I think about my future plans.", "Yo pienso en mis planes futuros.", "pienso",
                "She thought the movie was excellent.", "Ella pensó que la película era excelente.", "pensó",
                "We have thought of a solution.", "Nosotros hemos pensado en una solución.", "hemos pensado"),

            Verb("throw", "threw", "thrown", "Lanzar",
                "The pitcher throws the ball fast.", "El lanzador lanza la pelota rápido.", "lanza",
                "He threw the old newspapers away.", "Él tiró los periódicos viejos.", "tiró",
                "She has thrown a party for her friends.", "Ella ha organizado una fiesta para sus amigos.", "ha organizado"),

            Verb("understand", "understood", "understood", "Entender",
                "I understand the lesson now.", "Yo entiendo la lección ahora.", "entiendo",
                "She understood the instructions clearly.", "Ella entendió las instrucciones claramente.", "entendió",
                "We have understood the importance of this.", "Nosotros hemos entendido la importancia de esto.", "hemos entendido"),

            Verb("undergo", "underwent", "undergone", "Someterse a",
                "Patients undergo medical tests.", "Los pacientes se someten a pruebas médicas.", "se someten",
                "He underwent surgery last month.", "Él se sometió a cirugía el mes pasado.", "se sometió",
                "The system has undergone major changes.", "El sistema se ha sometido a cambios mayores.", "se ha sometido"),

            Verb("wake", "woke", "woken", "Despertar",
                "I wake at seven o'clock each morning.", "Yo me despierto a las siete cada mañana.", "me despierto",
                "The noise woke the baby.", "El ruido despertó al bebé.", "despertó",
                "She has woken up early today.", "Ella se ha despertado temprano hoy.", "se ha despertado"),

            Verb("wear", "wore", "worn", "Llevar puesto",
                "He wears a suit to work.", "Él lleva un traje al trabajo.", "lleva",
                "She wore a beautiful dress to the party.", "Ella llevó un vestido hermoso a la fiesta.", "llevó",
                "I have worn these shoes for years.", "Yo he usado estos zapatos por años.", "he usado"),

            Verb("weep", "wept", "wept", "Llorar",
                "She weeps during sad movies.", "Ella llora durante las películas tristes.", "llora",
                "He wept when he heard the news.", "Él lloró cuando escuchó las noticias.", "lloró",
                "The mother has wept for her lost child.", "La madre ha llorado por su hijo perdido.", "ha llorado"),

            Verb("wet", "wet/wetted", "wet/wetted", "Mojar",
                "I wet the cloth before cleaning.", "Yo mojo el trapo antes de limpiar.", "mojo",
                "She wet her hair under the shower.", "Ella mojó su cabello bajo la ducha.", "mojó",
                "The rain has wet the ground completely.", "La lluvia ha mojado el suelo completamente.", "ha mojado"),

            Verb("win", "won", "won", "Ganar",
                "Our team wins most games.", "Nuestro equipo gana la mayoría de los juegos.", "gana",
                "She won first prize in the contest.", "Ella ganó el primer premio en el concurso.", "ganó",
                "He has won many awards for his work.", "Él ha ganado muchos premios por su trabajo.", "ha ganado"),

            Verb("wind", "wound", "wound", "Enrollar",
                "She winds the yarn into a ball.", "Ella enrolla el hilo en una bola.", "enrolla",
                "He wound the clock every Sunday.", "Él le dio cuerda al reloj cada domingo.", "dio cuerda",
                "The road has wound through the mountains.", "La carretera ha serpenteado a través de las montañas.", "ha serpenteado"),

            Verb("withdraw", "withdrew", "withdrawn", "Retirar",
                "I withdraw money from the bank.", "Yo retiro dinero del banco.", "retiro",
                "He withdrew from the competition.", "Él se retiró de la competencia.", "se retiró",
                "The company has withdrawn the product.", "La compañía ha retirado el producto.", "ha retirado"),

            Verb("write", "wrote", "written", "Escribir",
                "She writes in her journal every night.", "Ella escribe en su diario cada noche.", "escribe",
                "I wrote a letter to my grandmother.", "Yo escribí una carta a mi abuela.", "escribí",
                "He has written several books.", "Él ha escrito varios libros.", "ha escrito"),
            )

    override fun getVerbs(): List<Verb> = irregularVerbs
}
