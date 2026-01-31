package com.goldsanchez.learnverbsenglish.data

import com.goldsanchez.learnverbsenglish.domain.model.Story
import com.goldsanchez.learnverbsenglish.domain.model.StoryWord

interface StoryRepository {
    fun getStories(): List<Story>
    fun getStoryById(id: String): Story?
}

class StoryRepositoryImpl : StoryRepository {
    private val stories = listOf(
        Story(
            id = "1",
            title = "A Productive Morning",
            level = "Basic",
            isPremium = false,
            content = "Every single day, I wake up exactly at 7 AM when my alarm goes off. I don't like to stay in bed, so I get up immediately and go to the kitchen. First, I drink a large glass of cold water and eat a healthy breakfast with fruit. After that, I put on my favorite running shoes and go out for a quick walk in the park. It is the best way to start the day before I sit down to work on my computer.",
            spanishContent = "Cada día, me despierto exactamente a las 7 AM cuando mi alarma suena. No me gusta quedarme en la cama, así que me levanto inmediatamente y voy a la cocina. Primero, bebo un vaso grande de agua fría y como un desayuno saludable con fruta. Después de eso, me pongo mis zapatillas de correr favoritas y salgo a dar un paseo rápido por el parque. Es la mejor manera de empezar el día antes de sentarme a trabajar en mi computadora.",
            keyWords = listOf(
                StoryWord("wake up", "despierto", "despertarse", "wake up", "Phrasal"),
                StoryWord("goes off", "suena", "sonar (alarma)", "go off", "Phrasal"),
                StoryWord("get up", "levanto", "levantarse", "get up", "Phrasal"),
                StoryWord("go", "voy", "ir", "go", "Irregular"),
                StoryWord("drink", "bebo", "beber", "drink", "Irregular"),
                StoryWord("eat", "como", "comer", "eat", "Irregular"),
                StoryWord("put on", "pongo", "ponerse (ropa)", "put on", "Phrasal"),
                StoryWord("go out", "salgo", "salir", "go out", "Phrasal"),
                StoryWord("sit down", "sentarme", "sentarse", "sit down", "Phrasal")
            )
        ),
        Story(
            id = "2",
            title = "The Mystery of the Cabin",
            level = "Intermediate",
            isPremium = false,
            content = "Last winter, while we were hiking, we found a mysterious old cabin hidden deep in the woods. The door was locked, but we accidentally broke the old wood. We felt bad, but we had lost our map and it was getting dark. Inside, we saw strange drawings on the walls. We sat down on the floor and spoke about what to do. Suddenly, we heard a noise. We stood up quickly and ran outside as fast as we could.",
            spanishContent = "El invierno pasado, mientras hacíamos senderismo, encontramos una misteriosa cabaña vieja escondida en lo profundo del bosque. La puerta estaba cerrada, pero accidentalmente rompimos la madera vieja. Nos sentimos mal, pero habíamos perdido nuestro mapa y estaba oscureciendo. Por dentro, vimos dibujos extraños en las paredes. Nos sentamos en el suelo y hablamos sobre qué hacer. De repente, oímos un ruido. Nos pusimos de pie rápidamente y corrimos afuera tan rápido como pudimos.",
            keyWords = listOf(
                StoryWord("found", "encontramos", "encontrar", "find", "Irregular"),
                StoryWord("broke", "rompimos", "romper", "break", "Irregular"),
                StoryWord("lost", "habíamos perdido", "perder", "lose", "Irregular"),
                StoryWord("saw", "vimos", "ver", "see", "Irregular"),
                StoryWord("sat down", "sentamos", "sentarse", "sit down", "Phrasal"),
                StoryWord("spoke", "hablamos", "hablar", "speak", "Irregular"),
                StoryWord("stood up", "pusimos de pie", "ponerse de pie", "stand up", "Phrasal"),
                StoryWord("ran", "corrimos", "correr", "run", "Irregular")
            )
        ),
        Story(
            id = "3",
            title = "Catching Up",
            level = "Intermediate",
            isPremium = false,
            content = "Yesterday, I ran into my childhood friend Mark at the mall. We hadn't seen each other in years, so we decided to catch up over some coffee. He told me many interesting things about his life. He finally gave up smoking and started a new company. We got along so well that we talked for three hours. Before leaving, he brought up the idea of traveling together next summer. I think it's a great plan!",
            spanishContent = "Ayer, me encontré con mi amigo de la infancia Mark en el centro comercial. No nos habíamos visto en años, así que decidimos ponernos al día tomando un café. Me contó muchas cosas interesantes sobre su vida. Finalmente dejó de fumar y comenzó una nueva empresa. Nos llevamos tan bien que hablamos durante tres horas. Antes de irse, mencionó la idea de viajar juntos el próximo verano. ¡Creo que es un gran plan!",
            keyWords = listOf(
                StoryWord("ran into", "encontré", "encontrarse con", "run into", "Phrasal"),
                StoryWord("seen", "visto", "ver", "see", "Irregular"),
                StoryWord("catch up", "ponernos al día", "ponerse al día", "catch up", "Phrasal"),
                StoryWord("told", "contó", "decir/contar", "tell", "Irregular"),
                StoryWord("gave up", "dejó", "dejar/rendirse", "give up", "Phrasal"),
                StoryWord("got along", "llevamos", "llevarse bien", "get along", "Phrasal"),
                StoryWord("brought up", "mencionó", "mencionar un tema", "bring up", "Phrasal")
            )
        ),
        Story(
            id = "4",
            title = "A Trip to London",
            level = "Basic",
            isPremium = false,
            content = "Last month, I went to London for the first time. I set off very early to catch the flight. When I arrived at the hotel, I had to check in. I saw the Big Ben and took many photos. I also bought some souvenirs for my family. I had a wonderful time exploring the city streets.",
            spanishContent = "El mes pasado, fui a Londres por primera vez. Salí muy temprano para tomar el vuelo. Cuando llegué al hotel, tuve que registrarme. Vi el Big Ben y tomé muchas fotos. También compré algunos recuerdos para mi familia. Pasé un tiempo maravilloso explorando las calles de la ciudad.",
            keyWords = listOf(
                StoryWord("went", "fui", "ir", "go", "Irregular"),
                StoryWord("set off", "Salí", "salir/partir", "set off", "Phrasal"),
                StoryWord("check in", "registrarme", "registrarse", "check in", "Phrasal"),
                StoryWord("saw", "Vi", "ver", "see", "Irregular"),
                StoryWord("took", "tomé", "tomar", "take", "Irregular"),
                StoryWord("bought", "compré", "comprar", "buy", "Irregular"),
                StoryWord("had", "Pasé", "tener/pasar", "have", "Irregular")
            )
        ),
        Story(
            id = "5",
            title = "The Job Interview",
            level = "Advanced",
            isPremium = false,
            content = "I had been looking for a job for months. Finally, a big company called me. Before the interview, I had to fill out many forms. During the meeting, the manager pointed out my experience in marketing. I tried to show off my skills without being arrogant. At the end, they told me I got the job. I was so happy that I almost broke down in tears!",
            spanishContent = "Había estado buscando trabajo durante meses. Finalmente, una gran empresa me llamó. Antes de la entrevista, tuve que completar muchos formularios. Durante la reunión, el gerente señaló mi experiencia en marketing. Intenté presumir mis habilidades sin ser arrogante. Al final, me dijeron que conseguí el trabajo. ¡Estaba tan feliz que casi me eché a llorar!",
            keyWords = listOf(
                StoryWord("looking for", "buscando", "buscar", "look for", "Phrasal"),
                StoryWord("fill out", "completar", "rellenar", "fill out", "Phrasal"),
                StoryWord("pointed out", "señaló", "señalar", "point out", "Phrasal"),
                StoryWord("show off", "presumir", "alardear", "show off", "Phrasal"),
                StoryWord("told", "dijeron", "decir/contar", "tell", "Irregular"),
                StoryWord("broke down", "eché a llorar", "derrumbarse", "break down", "Phrasal")
            )
        ),
        Story(
            id = "6",
            title = "Weekend at the Lake",
            level = "Basic",
            isPremium = false,
            content = "Last Saturday, we drove to the lake. The weather was perfect. We swam in the cold water and felt very refreshed. My father caught a big fish while my mother read a book under a tree. We ate sandwiches and drank lemonade. We sat there until the sun went down.",
            spanishContent = "El sábado pasado, condujimos al lago. El clima estaba perfecto. Nadamos en el agua fría y nos sentimos muy refrescados. Mi padre pescó un pez grande mientras mi madre leía un libro bajo un árbol. Comimos sándwiches y bebimos limonada. Nos sentamos allí hasta que el sol se puso.",
            keyWords = listOf(
                StoryWord("drove", "condujimos", "conducir", "drive", "Irregular"),
                StoryWord("swam", "Nadamos", "nadar", "swim", "Irregular"),
                StoryWord("felt", "sentimos", "sentir", "feel", "Irregular"),
                StoryWord("caught", "pescó", "atrapar/pescar", "catch", "Irregular"),
                StoryWord("read", "leía", "leer", "read", "Irregular"),
                StoryWord("ate", "Comimos", "comer", "eat", "Irregular"),
                StoryWord("drank", "bebimos", "beber", "drink", "Irregular"),
                StoryWord("sat", "sentamos", "sentar", "sit", "Irregular"),
                StoryWord("went down", "puso", "bajarse/ponerse(sol)", "go down", "Phrasal")
            )
        ),
        Story(
            id = "7",
            title = "The Surprise Party",
            level = "Intermediate",
            isPremium = false,
            content = "We decided to throw a surprise party for Julia. We told everyone to turn up at 8 PM. I had to bring over the cake and some decorations. We almost gave away the secret because Mark spoke too loudly on the phone. Luckily, Julia didn't find out. When she entered the room, we all stood up and shouted: Surprise!",
            spanishContent = "Decidimos dar una fiesta sorpresa para Julia. Les dijimos a todos que aparecieran a las 8 PM. Tuve que traer el pastel y algunas decoraciones. Casi revelamos el secreto porque Mark habló demasiado alto por teléfono. Por suerte, Julia no se enteró. Cuando entró en la habitación, todos nos pusimos de pie y gritamos: ¡Sorpresa!",
            keyWords = listOf(
                StoryWord("told", "dijimos", "decir", "tell", "Irregular"),
                StoryWord("turn up", "aparecieran", "aparecer/llegar", "turn up", "Phrasal"),
                StoryWord("bring over", "traer", "traer a casa de alguien", "bring over", "Phrasal"),
                StoryWord("gave away", "revelamos", "revelar un secreto", "give away", "Phrasal"),
                StoryWord("spoke", "habló", "hablar", "speak", "Irregular"),
                StoryWord("find out", "enteró", "enterarse", "find out", "Phrasal"),
                StoryWord("stood up", "pusimos de pie", "ponerse de pie", "stand up", "Phrasal")
            )
        ),
        Story(
            id = "8",
            title = "New Technology",
            level = "Advanced",
            isPremium = false,
            content = "Technology has grown so fast in the last decade. Many things that we knew in the past have become obsolete. New gadgets come out every week. Engineers keep on working to improve artificial intelligence. Many experts think that robots will take over some jobs in the future. We must learn to adapt to these changes.",
            spanishContent = "La tecnología ha crecido muy rápido en la última década. Muchos cosas que sabíamos en el pasado se han vuelto obsoletas. Nuevos dispositivos salen cada semana. Los ingenieros siguen trabajando para mejorar la inteligencia artificial. Muchos expertos piensan que los robots se harán cargo de algunos trabajos en el futuro. Debemos aprender a adaptarnos a estos cambios.",
            keyWords = listOf(
                StoryWord("grown", "crecido", "crecer", "grow", "Irregular"),
                StoryWord("knew", "sabíamos", "saber", "know", "Irregular"),
                StoryWord("become", "vuelto", "volverse/llegar a ser", "become", "Irregular"),
                StoryWord("come out", "salen", "salir al mercado", "come out", "Phrasal"),
                StoryWord("keep on", "siguen", "continuar", "keep on", "Phrasal"),
                StoryWord("take over", "harán cargo", "tomar el control", "take over", "Phrasal")
            )
        ),
        Story(
            id = "9",
            title = "The Lost Puppy",
            level = "Basic",
            isPremium = false,
            content = "Last night, I found a small puppy in the street. I decided to look after him for a few days. I went to the store and bought some food. I also picked up a small bed. I put an ad online to find the owner. Two days later, a woman called me. She had lost her dog in the park. She came to my house and took him back. I felt happy for them.",
            spanishContent = "Anoche, encontré un perrito pequeño en la calle. Decidimos cuidarlo por unos días. Fui a la tienda y compré algo de comida. También recogí una camita. Puse un anuncio en línea para encontrar al dueño. Dos días después, una mujer me llamó. Había perdido a su perro en el parque. Vino a mi casa y se lo llevó de vuelta. Me sentí feliz por ellos.",
            keyWords = listOf(
                StoryWord("found", "encontré", "encontrar", "find", "Irregular"),
                StoryWord("look after", "cuidarlo", "cuidar a alguien", "look after", "Phrasal"),
                StoryWord("went", "Fui", "ir", "go", "Irregular"),
                StoryWord("bought", "compré", "comprar", "buy", "Irregular"),
                StoryWord("picked up", "recogí", "recoger", "pick up", "Phrasal"),
                StoryWord("lost", "perdido", "perder", "lose", "Irregular"),
                StoryWord("came", "Vino", "venir", "come", "Irregular"),
                StoryWord("took him back", "llevó de vuelta", "devolver algo", "take back", "Phrasal"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular")
            )
        ),
        Story(
            id = "10",
            title = "Cooking Dinner",
            level = "Basic",
            isPremium = false,
            content = "Tonight, I made dinner for my family. I cut some vegetables and put them in a pot. I forgot to add salt at first. Soon, the kitchen smelt delicious. I laid the table and called everyone. We all sat together and had a nice meal. After dinner, I cleaned up the kitchen and threw away the trash.",
            spanishContent = "Esta noche, hice la cena para mi familia. Corté algunas verduras y las puse en una olla. Olvidé añadir sal al principio. Pronto, la cocina olió delicioso. Puse la mesa y llamé a todos. Todos nos sentamos juntos y tuvimos una buena comida. Después de la cena, limpié la cocina y tiré la basura.",
            keyWords = listOf(
                StoryWord("made", "hice", "hacer", "make", "Irregular"),
                StoryWord("cut", "Corté", "cortar", "cut", "Irregular"),
                StoryWord("put", "puse", "poner", "put", "Irregular"),
                StoryWord("smelt", "olió", "oler", "smell", "Irregular"),
                StoryWord("laid", "Puse", "poner/extender", "lay", "Irregular"),
                StoryWord("sat", "sentamos", "sentar", "sit", "Irregular"),
                StoryWord("had", "tuvimos", "tener", "have", "Irregular"),
                StoryWord("cleaned up", "limpié", "limpiar a fondo", "clean up", "Phrasal"),
                StoryWord("threw away", "tiré", "tirar/desechar", "throw away", "Phrasal")
            )
        ),
        Story(
            id = "11",
            title = "Moving House",
            level = "Intermediate",
            isPremium = false,
            content = "We moved to a new house last week. We had to pack up all our things in boxes. We decided to get rid of some old furniture that we didn't need. When we arrived at the new place, we began to unpack. My brother helped me put up the shelves in my room. It took us three days to settle in completely.",
            spanishContent = "Nos mudamos a una casa nueva la semana pasada. Tuvimos que empacar todas nuestras cosas en cajas. Decidimos deshacernos de algunos muebles viejos que no necesitábamos. Cuando llegamos al nuevo lugar, empezamos a desempacar. Mi hermano me ayudó a colgar los estantes en mi habitación. Nos tomó tres días instalarnos por completo.",
            keyWords = listOf(
                StoryWord("pack up", "empacar", "empaquetar", "pack up", "Phrasal"),
                StoryWord("get rid of", "deshacernos", "deshacerse de", "get rid of", "Phrasal"),
                StoryWord("began", "empezamos", "empezar", "begin", "Irregular"),
                StoryWord("put up", "colgar", "instalar/colgar", "put up", "Phrasal"),
                StoryWord("took", "tomó", "tomar/tardar", "take", "Irregular"),
                StoryWord("settle in", "instalarnos", "instalarse", "settle in", "Phrasal")
            )
        ),
        Story(
            id = "12",
            title = "Historical Leaders",
            level = "Advanced",
            isPremium = false,
            content = "Many historical leaders fought for freedom. They led their people through difficult times. Some won great battles, while others sought peace. They wrote important documents that changed the world. We should not forget what they did for us. Their courage became an example for future generations.",
            spanishContent = "Muchos líderes históricos lucharon por la libertad. Guiaron a su pueblo a través de tiempos difíciles. Algunos ganaron grandes batallas, mientras que otros buscaron la paz. Escribieron documentos importantes que cambiaron el mundo. No debemos olvidar lo que hicieron por nosotros. Su coraje se convirtió en un ejemplo para las generaciones futuras.",
            keyWords = listOf(
                StoryWord("fought", "lucharon", "luchar", "fight", "Irregular"),
                StoryWord("led", "Guiaron", "guiar/liderar", "lead", "Irregular"),
                StoryWord("won", "ganaron", "ganar", "win", "Irregular"),
                StoryWord("sought", "buscaron", "buscar", "seek", "Irregular"),
                StoryWord("wrote", "Escribieron", "escribir", "write", "Irregular"),
                StoryWord("did", "hicieron", "hacer", "do", "Irregular"),
                StoryWord("became", "convirtió", "convertirse", "become", "Irregular")
            )
        ),
        Story(
            id = "13",
            title = "Learning a Language",
            level = "Intermediate",
            isPremium = false,
            content = "Learning English is a journey. Sometimes you want to give up when grammar gets difficult. But you must keep on practicing every day. It is helpful to pick up new words from movies and songs. I once read that if you stick to a routine, you will speak fluently soon. Don't be afraid to make mistakes!",
            spanishContent = "Aprender inglés es un viaje. A veces quieres rendirte cuando la gramática se vuelve difícil. Pero debes seguir practicando todos los días. Es útil aprender nuevas palabras de películas y canciones. Una vez leí que si te apegas a una rutina, hablarás con fluidez pronto. ¡No tengas miedo de cometer errores!",
            keyWords = listOf(
                StoryWord("give up", "rendirte", "rendirse", "give up", "Phrasal"),
                StoryWord("keep on", "seguir", "continuar", "keep on", "Phrasal"),
                StoryWord("pick up", "aprender", "adquirir/aprender", "pick up", "Phrasal"),
                StoryWord("read", "leí", "leer", "read", "Irregular"),
                StoryWord("stick to", "apegas", "apegarse a", "stick to", "Phrasal"),
                StoryWord("make", "cometer", "hacer/cometer", "make", "Irregular")
            )
        ),
        Story(
            id = "14",
            title = "The Science Fair",
            level = "Basic",
            isPremium = false,
            content = "My sister participated in the school science fair. She drew a large diagram of a volcano. She made a model using paper and glue. She showed her project to the judges. They liked it very much. She won the second prize. She felt very proud because she worked hard on it.",
            spanishContent = "Mi hermana participó en la feria de ciencias de la escuela. Dibujó un diagrama grande de un volcán. Hizo un modelo usando papel y pegamento. Mostró su proyecto a los jueces. Les gustó mucho. Ganó el segundo premio. Se sintió muy orgullosa porque trabajó duro en ello.",
            keyWords = listOf(
                StoryWord("drew", "Dibujó", "dibujar", "draw", "Irregular"),
                StoryWord("made", "Hizo", "hacer", "make", "Irregular"),
                StoryWord("showed", "Mostró", "mostrar", "show", "Irregular"),
                StoryWord("won", "Ganó", "ganar", "win", "Irregular"),
                StoryWord("felt", "sintió", "sentir", "feel", "Irregular")
            )
        ),
        Story(
            id = "15",
            title = "Sports Competition",
            level = "Intermediate",
            isPremium = false,
            content = "Before the race, all the athletes had to warm up. I usually work out at the gym three times a week to stay fit. During the competition, I ran as fast as I could. I didn't want to fall behind the other runners. Near the end, I felt tired, but I didn't give up. I finished in third place!",
            spanishContent = "Antes de la carrera, todos los atletas tuvieron que calentar. Normalmente entreno en el gimnasio tres veces a la semana para mantenerme en forma. Durante la competencia, corrí tan rápido como pude. No quería quedarme atrás de los otros corredores. Cerca del final, me sentí cansado, pero no me rendí. ¡Terminé en tercer lugar!",
            keyWords = listOf(
                StoryWord("warm up", "calentar", "calentar(deporte)", "warm up", "Phrasal"),
                StoryWord("work out", "entreno", "hacer ejercicio", "work out", "Phrasal"),
                StoryWord("ran", "corrí", "correr", "run", "Irregular"),
                StoryWord("fall behind", "quedarme atrás", "retrasarse", "fall behind", "Phrasal"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular"),
                StoryWord("give up", "rendí", "rendirse", "give up", "Phrasal")
            )
        ),
        Story(
            id = "16",
            title = "A Rainy Afternoon",
            level = "Basic",
            isPremium = false,
            content = "It was raining outside, so I stayed home. I sat by the window and thought about my future. I read a classic book for two hours. Then, I chose some jazz music to listen to. I felt very peaceful. Later, my brother came over and we played chess.",
            spanishContent = "Estaba lloviendo afuera, así que me quedé en casa. Me senté junto a la ventana y pensé en mi futuro. Leí un libro clásico durante dos horas. Luego, elegí algo de música jazz para escuchar. Me sentí muy tranquilo. Más tarde, mi hermano vino y jugamos al ajedrez.",
            keyWords = listOf(
                StoryWord("sat", "senté", "sentarse", "sit", "Irregular"),
                StoryWord("thought", "pensé", "pensar", "think", "Irregular"),
                StoryWord("read", "Leí", "leer", "read", "Irregular"),
                StoryWord("chose", "elegí", "elegir", "choose", "Irregular"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular"),
                StoryWord("came over", "vino", "venir a casa de alguien", "come over", "Phrasal")
            )
        ),
        Story(
            id = "17",
            title = "School Days",
            level = "Intermediate",
            isPremium = false,
            content = "I remember my school days clearly. Every Friday, we had to hand in our assignments. It was hard to get through the final exams. Sometimes, I stayed up late studying. I didn't want to fail. My teacher always encouraged us. I was so relieved when I finally graduated!",
            spanishContent = "Recuerdo mis días escolares claramente. Cada viernes, teníamos que entregar nuestras tareas. Era difícil superar los exámenes finales. A veces, me quedaba despierto hasta tarde estudiando. No quería reprobar. Mi profesor siempre nos animaba. ¡Me sentí tan aliviado cuando finalmente me gradué!",
            keyWords = listOf(
                StoryWord("hand in", "entregar", "entregar algo", "hand in", "Phrasal"),
                StoryWord("get through", "superar", "pasar/superar algo difícil", "get through", "Phrasal"),
                StoryWord("stayed up", "quedaba despierto", "quedarse despierto", "stay up", "Phrasal")
            )
        ),
        Story(
            id = "18",
            title = "Art Gallery Visit",
            level = "Intermediate",
            isPremium = false,
            content = "We visited an art gallery yesterday. We saw beautiful paintings. One artist drew amazing portraits using only charcoal. They hung the most expensive pieces in the central room. I stood in front of a landscape for ten minutes. It took my breath away. I bought a small print to remember the day.",
            spanishContent = "Visitamos una galería de arte ayer. Vimos pinturas hermosas. Un artista dibujó retratos increíbles usando solo carbón. Colgaron las piezas más caras en la sala central. Me paré frente a un paisaje durante diez minutos. Me dejó sin aliento. Compré una pequeña impresión para recordar el día.",
            keyWords = listOf(
                StoryWord("saw", "Vimos", "ver", "see", "Irregular"),
                StoryWord("drew", "dibujó", "dibujar", "draw", "Irregular"),
                StoryWord("hung", "Colgaron", "colgar", "hang", "Irregular"),
                StoryWord("stood", "paré", "pararse/estar de pie", "stand", "Irregular"),
                StoryWord("took", "dejó", "tomar/quitar", "take", "Irregular"),
                StoryWord("bought", "Compré", "comprar", "buy", "Irregular")
            )
        ),
        Story(
            id = "19",
            title = "My First Flight",
            level = "Basic",
            isPremium = false,
            content = "I was very nervous about my first flight. I got on the plane and found my seat. I was looking forward to seeing the clouds from above. When the plane began to take off, I closed my eyes. After a few minutes, I felt better. The flight attendant brought me some water. It was a great experience!",
            spanishContent = "Estaba muy nervioso por mi primer vuelo. Subí al avión y encontré mi asiento. Tenía muchas ganas de ver las nubes desde arriba. Cuando el avión empezó a despegar, cerré los ojos. Después de unos minutos, me sentí mejor. La azafata me trajo algo de agua. ¡Fue una gran experiencia!",
            keyWords = listOf(
                StoryWord("got on", "Subí", "subirse a un transporte", "get on", "Phrasal"),
                StoryWord("looking forward to", "Tenía muchas ganas", "tener ganas de/esperar con ansias", "look forward to", "Phrasal"),
                StoryWord("began", "empezó", "empezar", "begin", "Irregular"),
                StoryWord("take off", "despegar", "despegar(avión)", "take off", "Phrasal"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular")
            )
        ),
        Story(
            id = "20",
            title = "A Hospital Visit",
            level = "Intermediate",
            isPremium = false,
            content = "My friend hurt his leg playing soccer. I went to the hospital to see him. The doctor told him he needed to rest for two weeks. He felt a bit sad, but I brought him some magazines. We talked about the game. I told him he would get over it soon. He smiled and thanked me.",
            spanishContent = "Mi amigo se lastimó la pierna jugando al fútbol. Fui al hospital para verlo. El médico le dijo que necesitaba descansar por dos semanas. Se sintió un poco triste, pero le traje algunas revistas. Hablamos sobre el juego. Le dije que se recuperaría pronto. Sonrió y me dio las gracias.",
            keyWords = listOf(
                StoryWord("hurt", "lastimó", "herir/lastimar", "hurt", "Irregular"),
                StoryWord("went", "Fui", "ir", "go", "Irregular"),
                StoryWord("told", "dijo", "decir", "tell", "Irregular"),
                StoryWord("felt", "sintió", "sentir", "feel", "Irregular"),
                StoryWord("get over", "recuperaría", "recuperarse/superar", "get over", "Phrasal")
            )
        ),
        Story(
            id = "21",
            title = "At the Shopping Mall",
            level = "Basic",
            isPremium = false,
            content = "I spent the afternoon at the mall. I wanted to look for a new jacket. I tried on several different styles. Finally, I found a blue one that I liked. I went to the cashier and paid for it. Then, I looked around for some shoes, but I didn't see anything I liked. I went home at 6 PM.",
            spanishContent = "Pasé la tarde en el centro comercial. Quería buscar una chaqueta nueva. Me probé varios estilos diferentes. Finalmente, encontré una azul que me gustó. Fui al cajero y la pagué. Luego, eché un vistazo buscando zapatos, pero no vi nada que me gustara. Me fui a casa a las 6 PM.",
            keyWords = listOf(
                StoryWord("spent", "Pasé", "pasar/gastar", "spend", "Irregular"),
                StoryWord("look for", "buscar", "buscar", "look for", "Phrasal"),
                StoryWord("tried on", "probé", "probarse(ropa)", "try on", "Phrasal"),
                StoryWord("found", "encontré", "encontrar", "find", "Irregular"),
                StoryWord("paid for", "pagué", "pagar por algo", "pay for", "Phrasal"),
                StoryWord("looked around", "eché un vistazo", "mirar alrededor", "look around", "Phrasal")
            )
        ),
        Story(
            id = "22",
            title = "Library Mystery",
            level = "Advanced",
            isPremium = false,
            content = "While I was studying in the library, I found an old letter inside a book. It was hidden between the pages. I took it to my desk and read it carefully. The writer spoke about a secret treasure. I kept the letter in my bag. I didn't tell anyone about it. I felt like a detective in a movie!",
            spanishContent = "Mientras estaba estudiando en la biblioteca, encontré una carta vieja dentro de un libro. Estaba escondida entre las páginas. La llevé a mi escritorio y la leí con cuidado. El escritor hablaba sobre un tesoro secreto. Guardé la carta en mi bolso. No se lo conté a nadie. ¡Me sentí como un detective en una película!",
            keyWords = listOf(
                StoryWord("found", "encontré", "encontrar", "find", "Irregular"),
                StoryWord("took", "llevé", "llevar/tomar", "take", "Irregular"),
                StoryWord("read", "leí", "leer", "read", "Irregular"),
                StoryWord("spoke", "hablaba", "hablar", "speak", "Irregular"),
                StoryWord("kept", "Guardé", "guardar/mantener", "keep", "Irregular"),
                StoryWord("tell", "conté", "decir/contar", "tell", "Irregular"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular")
            )
        ),
        Story(
            id = "23",
            title = "The Broken Car",
            level = "Intermediate",
            isPremium = false,
            content = "My car broke down on the highway. I had to pull over and call for help. I was worried because I didn't want to miss my meeting. A mechanic arrived and looked at the engine. He told me he could fix it quickly. I had to get by using a taxi for the rest of the day. It was expensive but necessary.",
            spanishContent = "Mi coche se averió en la autopista. Tuve que orillarme y llamar para pedir ayuda. Estaba preocupado porque no quería perderme mi reunión. Un mecánico llegó y miró el motor. Me dijo que podía arreglarlo rápidamente. Tuve que arreglármelas usando un taxi por el resto del día. Fue caro pero necesario.",
            keyWords = listOf(
                StoryWord("broke down", "averió", "averiarse", "break down", "Phrasal"),
                StoryWord("pull over", "orillarme", "hacerse a un lado/detenerse con el coche", "pull over", "Phrasal"),
                StoryWord("told", "dijo", "decir", "tell", "Irregular"),
                StoryWord("get by", "arreglármelas", "apañárselas/sobrevivir", "get by", "Phrasal")
            )
        ),
        Story(
            id = "24",
            title = "A Garden Project",
            level = "Basic",
            isPremium = false,
            content = "This spring, I built a small garden. I dug several holes and planted flowers. My grandfather gave me some seeds. I grew tomatoes and carrots. Every day, I went outside to water them. They became very large and beautiful. I felt very happy seeing the results of my hard work.",
            spanishContent = "Esta primavera, construí un pequeño jardín. Cavé varios agujeros y planté flores. Mi abuelo me dio algunas semillas. Cultivé tomates y zanahorias. Cada día, salía afuera para regarlos. Se volvieron muy grandes y hermosos. Me sentí muy feliz viendo los resultados de mi arduo trabajo.",
            keyWords = listOf(
                StoryWord("built", "construí", "construir", "build", "Irregular"),
                StoryWord("dug", "Cavé", "cavar", "dig", "Irregular"),
                StoryWord("gave", "dio", "dar", "give", "Irregular"),
                StoryWord("grew", "Cultivé", "crecer/cultivar", "grow", "Irregular"),
                StoryWord("went", "salía", "ir", "go", "Irregular"),
                StoryWord("became", "volvieron", "volverse/llegar a ser", "become", "Irregular"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular")
            )
        ),
        Story(
            id = "25",
            title = "Office Meeting",
            level = "Advanced",
            isPremium = false,
            content = "We had an important meeting this morning. The boss decided to call off the afternoon session because of the storm. During the talk, my colleague brought up some good ideas for the project. We went over the budget together. I thought the meeting was very productive. We all left the office early.",
            spanishContent = "Tuvimos una reunión importante esta mañana. El jefe decidió cancelar la sesión de la tarde debido a la tormenta. Durante la charla, mi colega mencionó algunas buenas ideas para el proyecto. Revisamos el presupuesto juntos. Pensé que la reunión fue muy productiva. Todos nos fuimos de la oficina temprano.",
            keyWords = listOf(
                StoryWord("call off", "cancelar", "suspender/cancelar", "call off", "Phrasal"),
                StoryWord("brought up", "mencionó", "mencionar un tema", "bring up", "Phrasal"),
                StoryWord("went over", "Revisamos", "revisar", "go over", "Phrasal"),
                StoryWord("thought", "Pensé", "pensar", "think", "Irregular"),
                StoryWord("left", "fuimos", "irse/dejar", "leave", "Irregular")
            )
        ),
        Story(
            id = "26",
            title = "A Snowy Day",
            level = "Basic",
            isPremium = false,
            content = "It was a snowy day in January. I wore my warm coat and went outside. I saw children playing in the snow. I accidentally fell down on the ice, but I didn't get hurt. I made a snowman with a carrot for a nose. After that, I went back inside and drank some hot chocolate.",
            spanishContent = "Era un día nevado en enero. Me puse mi abrigo cálido y salí afuera. Vi a niños jugando en la nieve. Accidentalmente me caí en el hielo, pero no me lastimé. Hice un muñeco de nieve con una zanahoria como nariz. Después de eso, volví adentro y bebí un poco de chocolate caliente.",
            keyWords = listOf(
                StoryWord("wore", "puse", "llevar puesto/ponerse", "wear", "Irregular"),
                StoryWord("went", "salí", "ir", "go", "Irregular"),
                StoryWord("saw", "Vi", "ver", "see", "Irregular"),
                StoryWord("fell down", "caí", "caerse", "fall down", "Phrasal"),
                StoryWord("hurt", "lastimé", "herir/lastimar", "hurt", "Irregular"),
                StoryWord("made", "Hice", "hacer", "make", "Irregular"),
                StoryWord("drank", "bebí", "beber", "drink", "Irregular")
            )
        ),
        Story(
            id = "27",
            title = "The New Restaurant",
            level = "Intermediate",
            isPremium = false,
            content = "My friends and I decided to eat out last night. We looked for a new restaurant in the city center. We finally found a small Italian place. The menu was great. I couldn't decide what to order, so I asked the waiter. He recommended the pasta. We filled up on delicious food. It was a lovely evening!",
            spanishContent = "Mis amigos y yo decidimos comer fuera anoche. Buscamos un nuevo restaurante en el centro de la ciudad. Finalmente encontramos un pequeño lugar italiano. El menú era genial. No podía decidir qué pedir, así que le pregunté al camarero. Recomendó la pasta. Nos llenamos con comida deliciosa. ¡Fue una noche encantadora!",
            keyWords = listOf(
                StoryWord("eat out", "comer fuera", "comer fuera de casa", "eat out", "Phrasal"),
                StoryWord("look for", "Buscamos", "buscar", "look for", "Phrasal"),
                StoryWord("found", "encontramos", "encontrar", "find", "Irregular"),
                StoryWord("fill up", "llenamos", "llenar/saciarse", "fill up", "Phrasal")
            )
        ),
        Story(
            id = "28",
            title = "A Secret Gift",
            level = "Advanced",
            isPremium = false,
            content = "I gave a secret gift to my mother for her birthday. I hid it in the closet for a week. I sent her an anonymous card with a clue. She had to find out where the gift was. When she finally found it, she was very surprised. She told me it was the best gift she had ever received. I felt very happy.",
            spanishContent = "Le di un regalo secreto a mi madre por su cumpleaños. Lo escondí en el armario durante una semana. Le envié una tarjeta anónima con una pista. Ella tuvo que averiguar dónde estaba el regalo. Cuando finalmente lo encontró, se sorprendió mucho. Me dijo que era el mejor regalo que había recibido jamás. Me sentí muy feliz.",
            keyWords = listOf(
                StoryWord("gave", "di", "dar", "give", "Irregular"),
                StoryWord("hid", "escondí", "esconder", "hide", "Irregular"),
                StoryWord("sent", "envié", "enviar", "send", "Irregular"),
                StoryWord("find out", "averiguar", "descubrir/averiguar", "find out", "Phrasal"),
                StoryWord("found", "encontró", "encontrar", "find", "Irregular"),
                StoryWord("told", "dijo", "decir", "tell", "Irregular"),
                StoryWord("felt", "sentí", "sentir", "feel", "Irregular")
            )
        ),
        Story(
            id = "29",
            title = "Fitness Journey",
            level = "Intermediate",
            isPremium = false,
            content = "I started my fitness journey last year. I promised myself I wouldn't give up easily. I decided to stick to a strict exercise routine. I work out every morning before work. I have lost weight and I feel much stronger now. It is important to keep on moving to stay healthy.",
            spanishContent = "Empecé mi viaje de fitness el año pasado. Me prometí que no me rendiría fácilmente. Decidí apegarme a una rutina de ejercicio estricta. Entreno todas las mañanas antes del trabajo. He perdido peso y me siento mucho más fuerte ahora. Es importante seguir moviéndose para mantenerse saludable.",
            keyWords = listOf(
                StoryWord("give up", "rendiría", "rendirse", "give up", "Phrasal"),
                StoryWord("stick to", "apegarme", "apegarse a", "stick to", "Phrasal"),
                StoryWord("work out", "Entreno", "hacer ejercicio", "work out", "Phrasal"),
                StoryWord("lost", "perdido", "perder", "lose", "Irregular"),
                StoryWord("feel", "siento", "sentir", "feel", "Irregular"),
                StoryWord("keep on", "seguir", "continuar", "keep on", "Phrasal")
            )
        ),
        Story(
            id = "30",
            title = "Global Warming",
            level = "Advanced",
            isPremium = false,
            content = "The world has changed because of global warming. Sea levels have risen and the weather has become unpredictable. Scientists have understood the dangers for a long time. We must look after our planet before it's too late. We need to find out new ways to produce clean energy. Every small action counts!",
            spanishContent = "El mundo ha cambiado debido al calentamiento global. Los niveles del mar han subido y el clima se ha vuelto impredecible. Los científicos han comprendido los peligros durante mucho tiempo. Debemos cuidar nuestro planeta antes de que sea demasiado tarde. Necesitamos descubrir nuevas formas de producir energía limpia. ¡Cada pequeña acción cuenta!",
            keyWords = listOf(
                StoryWord("risen", "subido", "subir/ascender", "rise", "Irregular"),
                StoryWord("become", "vuelto", "volverse", "become", "Irregular"),
                StoryWord("understood", "comprendido", "entender", "understand", "Irregular"),
                StoryWord("look after", "cuidar", "cuidar de", "look after", "Phrasal"),
                StoryWord("find out", "descubrir", "descubrir/averiguar", "find out", "Phrasal")
            )
        )
    )

    override fun getStories(): List<Story> = stories
    override fun getStoryById(id: String): Story? = stories.find { it.id == id }
}
