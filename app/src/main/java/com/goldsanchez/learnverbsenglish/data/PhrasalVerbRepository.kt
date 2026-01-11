package com.goldsanchez.learnverbsenglish.data

import com.goldsanchez.learnverbsenglish.domain.model.PhrasalVerb

interface PhrasalVerbRepository {
    fun getPhrasalVerbs(): List<PhrasalVerb>
}

class PhrasalVerbRepositoryImpl : PhrasalVerbRepository {
    private val phrasalVerbs = listOf(
            PhrasalVerb(
                verb = "ask out",
                translation = "invitar a salir",
                usageContext = "Se usa para invitar a alguien a una cita romántica o social.",
                examplePresent = "He asks her out every Friday.",
                examplePresentTranslation = "Él la invita a salir cada viernes.",
                highlightSpanishPresent = "la invita",
                examplePast = "She asked him out last week.",
                examplePastTranslation = "Ella lo invitó a salir la semana pasada.",
                highlightSpanishPast = "lo invitó",
                exampleCommon = "I have never asked anyone out.",
                exampleCommonTranslation = "Yo nunca he invitado a nadie a salir.",
                highlightSpanishCommon = "he invitado"
            ),

            PhrasalVerb(
                verb = "back up",
                translation = "respaldar / hacer copia de seguridad",
                usageContext = "Se usa para:\n• Crear copias de seguridad de archivos\n• Apoyar una idea o persona\n• Retroceder (un vehículo)",
                examplePresent = "I always back up my computer files.",
                examplePresentTranslation = "Yo siempre respaldo los archivos de mi computadora.",
                highlightSpanishPresent = "respaldo",
                examplePast = "He backed up his claims with evidence.",
                examplePastTranslation = "Él respaldó sus afirmaciones con evidencia.",
                highlightSpanishPast = "respaldo",
                exampleCommon = "We have backed up all the data.",
                exampleCommonTranslation = "Nosotros hemos respaldado todos los datos.",
                highlightSpanishCommon = "hemos respaldo"
            ),

            PhrasalVerb(
                verb = "break down",
                translation = "averiarse / descomponerse",
                usageContext = "Se usa para:\n• Máquinas o vehículos que dejan de funcionar\n• Personas que pierden el control emocional\n• Desglosar información en partes",
                examplePresent = "My car often breaks down in winter.",
                examplePresentTranslation = "Mi coche a menudo se avería en invierno.",
                highlightSpanishPresent = "se avería",
                examplePast = "The washing machine broke down yesterday.",
                examplePastTranslation = "La lavadora se averió ayer.",
                highlightSpanishPast = "se averió",
                exampleCommon = "She has broken down three times this month.",
                exampleCommonTranslation = "Ella se ha descompuesto tres veces este mes.",
                highlightSpanishCommon = "se ha descompuesto"
            ),

            PhrasalVerb(
                verb = "break up",
                translation = "terminar una relación",
                usageContext = "Se usa específicamente para relaciones románticas que terminan.",
                examplePresent = "They break up and get back together frequently.",
                examplePresentTranslation = "Ellos terminan y vuelven juntos frecuentemente.",
                highlightSpanishPresent = "terminan",
                examplePast = "He broke up with his girlfriend last month.",
                examplePastTranslation = "Él terminó con su novia el mes pasado.",
                highlightSpanishPast = "terminó",
                exampleCommon = "They have broken up several times.",
                exampleCommonTranslation = "Ellos han terminado varias veces.",
                highlightSpanishCommon = "han terminado"
            ),

            PhrasalVerb(
                verb = "bring up",
                translation = "criar / mencionar",
                usageContext = "Se usa para:\n• Criar niños\n• Mencionar un tema en conversación",
                examplePresent = "She brings up interesting topics in meetings.",
                examplePresentTranslation = "Ella menciona temas interesantes en las reuniones.",
                highlightSpanishPresent = "menciona",
                examplePast = "He brought up his children alone.",
                examplePastTranslation = "Él crió a sus hijos solo.",
                highlightSpanishPast = "crió",
                exampleCommon = "We have brought up this issue before.",
                exampleCommonTranslation = "Nosotros hemos mencionado este asunto antes.",
                highlightSpanishCommon = "hemos mencionado"
            ),

            PhrasalVerb(
                verb = "call off",
                translation = "cancelar",
                usageContext = "Se usa para eventos, reuniones, planes o compromisos que se cancelan.",
                examplePresent = "They often call off meetings at the last minute.",
                examplePresentTranslation = "Ellos a menudo cancelan reuniones a último minuto.",
                highlightSpanishPresent = "cancelan",
                examplePast = "We called off the picnic due to rain.",
                examplePastTranslation = "Nosotros cancelamos el picnic debido a la lluvia.",
                highlightSpanishPast = "cancelamos",
                exampleCommon = "The concert has been called off.",
                exampleCommonTranslation = "El concierto ha sido cancelado.",
                highlightSpanishCommon = "ha sido cancelado"
            ),

            PhrasalVerb(
                verb = "calm down",
                translation = "calmarse",
                usageContext = "Se usa para pedir o sugerir que alguien se tranquilice.",
                examplePresent = "I calm down by taking deep breaths.",
                examplePresentTranslation = "Yo me calmo tomando respiraciones profundas.",
                highlightSpanishPresent = "me calmo",
                examplePast = "He calmed down after the explanation.",
                examplePastTranslation = "Él se calmó después de la explicación.",
                highlightSpanishPast = "se calmó",
                exampleCommon = "She has calmed down since this morning.",
                exampleCommonTranslation = "Ella se ha calmado desde esta mañana.",
                highlightSpanishCommon = "se ha calmado"
            ),

            PhrasalVerb(
                verb = "carry on",
                translation = "continuar / seguir",
                usageContext = "Se usa para continuar con una actividad o comportamiento.",
                examplePresent = "We carry on working despite the difficulties.",
                examplePresentTranslation = "Nosotros continuamos trabajando a pesar de las dificultades.",
                highlightSpanishPresent = "continuamos",
                examplePast = "They carried on with the project.",
                examplePastTranslation = "Ellos continuaron con el proyecto.",
                highlightSpanishPast = "continuaron",
                exampleCommon = "He has carried on as if nothing happened.",
                exampleCommonTranslation = "Él ha continuado como si nada hubiera pasado.",
                highlightSpanishCommon = "ha continuado"
            ),

            PhrasalVerb(
                verb = "carry out",
                translation = "llevar a cabo / realizar",
                usageContext = "Se usa para realizar tareas, experimentos, investigaciones o planes.",
                examplePresent = "Scientists carry out experiments daily.",
                examplePresentTranslation = "Los científicos llevan a cabo experimentos diariamente.",
                highlightSpanishPresent = "llevan a cabo",
                examplePast = "The team carried out the instructions perfectly.",
                examplePastTranslation = "El equipo llevó a cabo las instrucciones perfectamente.",
                highlightSpanishPast = "llevó a cabo",
                exampleCommon = "We have carried out all the necessary tests.",
                exampleCommonTranslation = "Nosotros hemos realizado todas las pruebas necesarias.",
                highlightSpanishCommon = "hemos realizado"
            ),

            PhrasalVerb(
                verb = "catch up",
                translation = "ponerse al día",
                usageContext = "Se usa para:\n• Alcanzar a alguien que va adelante\n• Actualizarse con noticias o trabajo",
                examplePresent = "I catch up with my friends every weekend.",
                examplePresentTranslation = "Yo me pongo al día con mis amigos cada fin de semana.",
                highlightSpanishPresent = "me pongo al día",
                examplePast = "She caught up with the rest of the group.",
                examplePastTranslation = "Ella se puso al día con el resto del grupo.",
                highlightSpanishPast = "se puso al día",
                exampleCommon = "We need to catch up on our work.",
                exampleCommonTranslation = "Nosotros necesitamos ponernos al día con nuestro trabajo.",
                highlightSpanishCommon = "ponernos al día"
            ),

            PhrasalVerb(
                verb = "check in",
                translation = "registrarse",
                usageContext = "Se usa para:\n• Hoteles (al llegar)\n• Aeropuertos (para vuelos)\n• Llegar y anunciar presencia",
                examplePresent = "We check in at the hotel at 3 PM.",
                examplePresentTranslation = "Nosotros nos registramos en el hotel a las 3 PM.",
                highlightSpanishPresent = "nos registramos",
                examplePast = "He checked in for his flight online.",
                examplePastTranslation = "Él se registró para su vuelo en línea.",
                highlightSpanishPast = "se registró",
                exampleCommon = "They have already checked in at the conference.",
                exampleCommonTranslation = "Ellos ya se han registrado en la conferencia.",
                highlightSpanishCommon = "se han registrado"
            ),

            PhrasalVerb(
                verb = "check out",
                translation = "salir (hotel) / revisar",
                usageContext = "Se usa para:\n• Salir de un hotel\n• Examinar o investigar algo\n• Sacar libros de biblioteca",
                examplePresent = "I check out books from the library weekly.",
                examplePresentTranslation = "Yo saco libros de la biblioteca semanalmente.",
                highlightSpanishPresent = "saco",
                examplePast = "We checked out of the hotel at 11 AM.",
                examplePastTranslation = "Nosotros salimos del hotel a las 11 AM.",
                highlightSpanishPast = "salimos",
                exampleCommon = "He has checked out that new restaurant.",
                exampleCommonTranslation = "Él ha probado ese nuevo restaurante.",
                highlightSpanishCommon = "ha probado"
            ),

            PhrasalVerb(
                verb = "clean up",
                translation = "limpiar",
                usageContext = "Se usa para limpiar un lugar desordenado o sucio.",
                examplePresent = "She cleans up her room every Saturday.",
                examplePresentTranslation = "Ella limpia su habitación cada sábado.",
                highlightSpanishPresent = "limpia",
                examplePast = "They cleaned up the park after the event.",
                examplePastTranslation = "Ellos limpiaron el parque después del evento.",
                highlightSpanishPast = "limpiaron",
                exampleCommon = "We have cleaned up the entire house.",
                exampleCommonTranslation = "Nosotros hemos limpiado toda la casa.",
                highlightSpanishCommon = "hemos limpiado"
            ),

            PhrasalVerb(
                verb = "come across",
                translation = "encontrarse con / toparse con",
                usageContext = "Se usa para encontrar algo o a alguien por casualidad.",
                examplePresent = "I often come across interesting articles online.",
                examplePresentTranslation = "Yo a menudo me encuentro con artículos interesantes en línea.",
                highlightSpanishPresent = "me encuentro",
                examplePast = "She came across an old photo album.",
                examplePastTranslation = "Ella se topó con un álbum de fotos viejo.",
                highlightSpanishPast = "se topó",
                exampleCommon = "He has come across that word several times.",
                exampleCommonTranslation = "Él se ha encontrado con esa palabra varias veces.",
                highlightSpanishCommon = "se ha encontrado"
            ),

            PhrasalVerb(
                verb = "come back",
                translation = "regresar / volver",
                usageContext = "Se usa para retornar a un lugar después de haber estado ausente.",
                examplePresent = "He always comes back home before midnight.",
                examplePresentTranslation = "Él siempre regresa a casa antes de la medianoche.",
                highlightSpanishPresent = "regresa",
                examplePast = "They came back from vacation yesterday.",
                examplePastTranslation = "Ellos regresaron de vacaciones ayer.",
                highlightSpanishPast = "regresaron",
                exampleCommon = "She has come back to her hometown.",
                exampleCommonTranslation = "Ella ha regresado a su ciudad natal.",
                highlightSpanishCommon = "ha regresado"
            ),

            PhrasalVerb(
                verb = "come in",
                translation = "entrar",
                usageContext = "Se usa para invitar o describir a alguien que entra a un lugar.",
                examplePresent = "Please come in and sit down.",
                examplePresentTranslation = "Por favor, entra y siéntate.",
                highlightSpanishPresent = "entra",
                examplePast = "He came in through the back door.",
                examplePastTranslation = "Él entró por la puerta trasera.",
                highlightSpanishPast = "entró",
                exampleCommon = "They have just come in from the rain.",
                exampleCommonTranslation = "Ellos acaban de entrar de la lluvia.",
                highlightSpanishCommon = "acaban de entrar"
            ),

            PhrasalVerb(
                verb = "come on",
                translation = "¡vamos! / ¡ánimo!",
                usageContext = "Se usa para animar a alguien o expresar incredulidad.",
                examplePresent = "Come on, you can do it!",
                examplePresentTranslation = "¡Vamos, tú puedes hacerlo!",
                highlightSpanishPresent = "Vamos",
                examplePast = "He came on too strong during the interview.",
                examplePastTranslation = "Él fue demasiado intenso durante la entrevista.",
                highlightSpanishPast = "fue",
                exampleCommon = "She has come on a lot in her studies.",
                exampleCommonTranslation = "Ella ha mejorado mucho en sus estudios.",
                highlightSpanishCommon = "ha mejorado"
            ),

            PhrasalVerb(
                verb = "come up",
                translation = "surgir / acercarse",
                usageContext = "Se usa para:\n• Problemas o temas que surgen\n• Eventos que se aproximan\n• Ascender o subir",
                examplePresent = "Problems often come up unexpectedly.",
                examplePresentTranslation = "Los problemas a menudo surgen inesperadamente.",
                highlightSpanishPresent = "surgen",
                examplePast = "A great opportunity came up last week.",
                examplePastTranslation = "Una gran oportunidad surgió la semana pasada.",
                highlightSpanishPast = "surgió",
                exampleCommon = "My birthday has come up quickly this year.",
                exampleCommonTranslation = "Mi cumpleaños se ha acercado rápidamente este año.",
                highlightSpanishCommon = "se ha acercado"
            ),

            PhrasalVerb(
                verb = "cut down",
                translation = "reducir",
                usageContext = "Se usa para reducir consumo, gastos o cantidades.",
                examplePresent = "I cut down on sugar to improve my health.",
                examplePresentTranslation = "Yo reduzco el azúcar para mejorar mi salud.",
                highlightSpanishPresent = "reduzco",
                examplePast = "They cut down their expenses last month.",
                examplePastTranslation = "Ellos redujeron sus gastos el mes pasado.",
                highlightSpanishPast = "redujeron",
                exampleCommon = "He has cut down on smoking significantly.",
                exampleCommonTranslation = "Él ha reducido el fumar significativamente.",
                highlightSpanishCommon = "ha reducido"
            ),

            PhrasalVerb(
                verb = "deal with",
                translation = "manejar / tratar con",
                usageContext = "Se usa para manejar situaciones, problemas o personas.",
                examplePresent = "She deals with difficult customers professionally.",
                examplePresentTranslation = "Ella maneja clientes difíciles profesionalmente.",
                highlightSpanishPresent = "maneja",
                examplePast = "We dealt with the emergency quickly.",
                examplePastTranslation = "Nosotros manejamos la emergencia rápidamente.",
                highlightSpanishPast = "manejamos",
                exampleCommon = "I have dealt with similar situations before.",
                exampleCommonTranslation = "Yo he manejado situaciones similares antes.",
                highlightSpanishCommon = "he manejado"
            ),

            PhrasalVerb(
                verb = "do over",
                translation = "hacer de nuevo / repetir",
                usageContext = "Se usa para repetir una tarea o actividad para mejorarla.",
                examplePresent = "Sometimes I do over my homework.",
                examplePresentTranslation = "A veces yo rehago mi tarea.",
                highlightSpanishPresent = "rehago",
                examplePast = "He did over the entire project.",
                examplePastTranslation = "Él rehizo todo el proyecto.",
                highlightSpanishPast = "rehizo",
                exampleCommon = "We have done over the calculations three times.",
                exampleCommonTranslation = "Nosotros hemos rehecho los cálculos tres veces.",
                highlightSpanishCommon = "hemos rehecho"
            ),

            PhrasalVerb(
                verb = "draw up",
                translation = "redactar / preparar",
                usageContext = "Se usa para preparar documentos, planes o contratos formalmente.",
                examplePresent = "Lawyers draw up contracts daily.",
                examplePresentTranslation = "Los abogados redactan contratos diariamente.",
                highlightSpanishPresent = "redactan",
                examplePast = "She drew up a detailed business plan.",
                examplePastTranslation = "Ella redactó un plan de negocios detallado.",
                highlightSpanishPast = "redactó",
                exampleCommon = "They have drawn up the agreement for signature.",
                exampleCommonTranslation = "Ellos han redactado el acuerdo para firma.",
                highlightSpanishCommon = "han redactado"
            ),

            PhrasalVerb(
                verb = "dream up",
                translation = "inventar / idear",
                usageContext = "Se usa para crear ideas, planes o historias imaginativas.",
                examplePresent = "Writers dream up fascinating stories.",
                examplePresentTranslation = "Los escritores inventan historias fascinantes.",
                highlightSpanishPresent = "inventan",
                examplePast = "He dreamed up a brilliant solution.",
                examplePastTranslation = "Él ideó una solución brillante.",
                highlightSpanishPast = "ideó",
                exampleCommon = "We have dreamed up many creative projects.",
                exampleCommonTranslation = "Nosotros hemos ideado muchos proyectos creativos.",
                highlightSpanishCommon = "hemos ideado"
            ),

            PhrasalVerb(
                verb = "dress up",
                translation = "vestirse elegante / disfrazarse",
                usageContext = "Se usa para:\n• Vestir ropa formal para ocasiones especiales\n• Ponerse un disfraz",
                examplePresent = "We dress up for important meetings.",
                examplePresentTranslation = "Nosotros nos vestimos elegante para reuniones importantes.",
                highlightSpanishPresent = "nos vestimos",
                examplePast = "She dressed up as a pirate for the party.",
                examplePastTranslation = "Ella se disfrazó de pirata para la fiesta.",
                highlightSpanishPast = "se disfrazó",
                exampleCommon = "They have dressed up for the wedding ceremony.",
                exampleCommonTranslation = "Ellos se han vestido elegante para la ceremonia de boda.",
                highlightSpanishCommon = "se han vestido"
            ),

            PhrasalVerb(
                verb = "drop off",
                translation = "dejar (a alguien o algo)",
                usageContext = "Se usa para:\n• Dejar a alguien en un lugar\n• Dejar un paquete o objeto\n• Disminuir o reducir",
                examplePresent = "I drop off my kids at school every morning.",
                examplePresentTranslation = "Yo dejo a mis hijos en la escuela cada mañana.",
                highlightSpanishPresent = "dejo",
                examplePast = "He dropped off the package at the post office.",
                examplePastTranslation = "Él dejó el paquete en la oficina de correos.",
                highlightSpanishPast = "dejó",
                exampleCommon = "Sales have dropped off this quarter.",
                exampleCommonTranslation = "Las ventas han disminuido este trimestre.",
                highlightSpanishCommon = "han disminuido"
            ),

            PhrasalVerb(
                verb = "end up",
                translation = "terminar / acabar",
                usageContext = "Se usa para describir un resultado final, a menudo inesperado.",
                examplePresent = "We often end up at the same café.",
                examplePresentTranslation = "Nosotros a menudo terminamos en el mismo café.",
                highlightSpanishPresent = "terminamos",
                examplePast = "They ended up getting married.",
                examplePastTranslation = "Ellos terminaron casándose.",
                highlightSpanishPast = "terminaron",
                exampleCommon = "He has ended up in a completely different career.",
                exampleCommonTranslation = "Él ha terminado en una carrera completamente diferente.",
                highlightSpanishCommon = "ha terminado"
            ),

            PhrasalVerb(
                verb = "fall apart",
                translation = "desmoronarse / deshacerse",
                usageContext = "Se usa para:\n• Objetos que se rompen en pedazos\n• Planes que fracasan\n• Personas que colapsan emocionalmente",
                examplePresent = "Old books often fall apart easily.",
                examplePresentTranslation = "Los libros viejos a menudo se deshacen fácilmente.",
                highlightSpanishPresent = "se deshacen",
                examplePast = "Their relationship fell apart last year.",
                examplePastTranslation = "Su relación se desmoronó el año pasado.",
                highlightSpanishPast = "se desmoronó",
                exampleCommon = "The plan has fallen apart completely.",
                exampleCommonTranslation = "El plan se ha desmoronado completamente.",
                highlightSpanishCommon = "se ha desmoronado"
            ),

            PhrasalVerb(
                verb = "fall out",
                translation = "pelearse / desprenderse",
                usageContext = "Se usa para:\n• Amigos que tienen una pelea\n• Cabello o dientes que se caen\n• Resultados de eventos",
                examplePresent = "Friends sometimes fall out over small things.",
                examplePresentTranslation = "Los amigos a veces se pelean por cosas pequeñas.",
                highlightSpanishPresent = "se pelean",
                examplePast = "They fell out after the argument.",
                examplePastTranslation = "Ellos se pelearon después de la discusión.",
                highlightSpanishPast = "se pelearon",
                exampleCommon = "Things have fallen out differently than expected.",
                exampleCommonTranslation = "Las cosas han resultado diferente de lo esperado.",
                highlightSpanishCommon = "han resultado"
            ),

            PhrasalVerb(
                verb = "figure out",
                translation = "resolver / descifrar",
                usageContext = "Se usa para encontrar soluciones o comprender algo complejo.",
                examplePresent = "I figure out math problems step by step.",
                examplePresentTranslation = "Yo resuelvo problemas de matemáticas paso a paso.",
                highlightSpanishPresent = "resuelvo",
                examplePast = "She figured out how to fix the computer.",
                examplePastTranslation = "Ella resolvió cómo arreglar la computadora.",
                highlightSpanishPast = "resolvió",
                exampleCommon = "We have finally figured out the solution.",
                exampleCommonTranslation = "Nosotros finalmente hemos descifrado la solución.",
                highlightSpanishCommon = "hemos descifrado"
            ),

            PhrasalVerb(
                verb = "fill in",
                translation = "rellenar / sustituir",
                usageContext = "Se usa para:\n• Completar formularios o espacios vacíos\n• Reemplazar a alguien temporalmente",
                examplePresent = "Applicants fill in the form with their details.",
                examplePresentTranslation = "Los solicitantes rellenan el formulario con sus datos.",
                highlightSpanishPresent = "rellenan",
                examplePast = "He filled in for the manager last week.",
                examplePastTranslation = "Él sustituyó al gerente la semana pasada.",
                highlightSpanishPast = "sustituyó",
                exampleCommon = "I have filled in all the required fields.",
                exampleCommonTranslation = "Yo he rellenado todos los campos requeridos.",
                highlightSpanishCommon = "he rellenado"
            ),

            PhrasalVerb(
                verb = "fill out",
                translation = "completar (formulario)",
                usageContext = "Se usa específicamente para completar formularios o documentos.",
                examplePresent = "Patients fill out medical forms at the clinic.",
                examplePresentTranslation = "Los pacientes completan formularios médicos en la clínica.",
                highlightSpanishPresent = "completan",
                examplePast = "I filled out the application yesterday.",
                examplePastTranslation = "Yo completé la aplicación ayer.",
                highlightSpanishPast = "completé",
                exampleCommon = "She has filled out all the paperwork.",
                exampleCommonTranslation = "Ella ha completado todo el papeleo.",
                highlightSpanishCommon = "ha completado"
            ),

            PhrasalVerb(
                verb = "find out",
                translation = "descubrir / enterarse",
                usageContext = "Se usa para obtener información o descubrir algo que no se sabía.",
                examplePresent = "I find out news from the internet.",
                examplePresentTranslation = "Yo me entero de las noticias por internet.",
                highlightSpanishPresent = "me entero",
                examplePast = "They found out the truth about the incident.",
                examplePastTranslation = "Ellos descubrieron la verdad sobre el incidente.",
                highlightSpanishPast = "descubrieron",
                exampleCommon = "We have found out what caused the problem.",
                exampleCommonTranslation = "Nosotros hemos descubierto qué causó el problema.",
                highlightSpanishCommon = "hemos descubierto"
            ),

            PhrasalVerb(
                verb = "get across",
                translation = "comunicar / hacer entender",
                usageContext = "Se usa para hacer que un mensaje o idea sea comprendido por otros.",
                examplePresent = "Teachers try to get across complex concepts.",
                examplePresentTranslation = "Los profesores tratan de comunicar conceptos complejos.",
                highlightSpanishPresent = "comunicar",
                examplePast = "He got across his point clearly.",
                examplePastTranslation = "Él hizo entender su punto claramente.",
                highlightSpanishPast = "hizo entender",
                exampleCommon = "The message has gotten across to everyone.",
                exampleCommonTranslation = "El mensaje se ha hecho entender a todos.",
                highlightSpanishCommon = "se ha hecho entender"
            ),

            PhrasalVerb(
                verb = "get along",
                translation = "llevarse bien",
                usageContext = "Se usa para describir relaciones armoniosas entre personas.",
                examplePresent = "We get along very well with our neighbors.",
                examplePresentTranslation = "Nosotros nos llevamos muy bien con nuestros vecinos.",
                highlightSpanishPresent = "nos llevamos",
                examplePast = "They got along immediately when they met.",
                examplePastTranslation = "Ellos se llevaron bien inmediatamente cuando se conocieron.",
                highlightSpanishPast = "se llevaron",
                exampleCommon = "I have always gotten along with my coworkers.",
                exampleCommonTranslation = "Yo siempre me he llevado bien con mis compañeros de trabajo.",
                highlightSpanishCommon = "me he llevado"
            ),

            PhrasalVerb(
                verb = "get away",
                translation = "escaparse / irse de vacaciones",
                usageContext = "Se usa para:\n• Escapar de una situación\n• Tomar vacaciones o tiempo libre",
                examplePresent = "We get away to the mountains every summer.",
                examplePresentTranslation = "Nosotros nos vamos a las montañas cada verano.",
                highlightSpanishPresent = "nos vamos",
                examplePast = "The thief got away with the money.",
                examplePastTranslation = "El ladrón se escapó con el dinero.",
                highlightSpanishPast = "se escapó",
                exampleCommon = "They have gotten away from the city stress.",
                exampleCommonTranslation = "Ellos se han alejado del estrés de la ciudad.",
                highlightSpanishCommon = "se han alejado"
            ),

            PhrasalVerb(
                verb = "get back",
                translation = "regresar / recuperar",
                usageContext = "Se usa para:\n• Volver a un lugar\n• Recuperar algo perdido o prestado",
                examplePresent = "I always get back home before dark.",
                examplePresentTranslation = "Yo siempre regreso a casa antes del anochecer.",
                highlightSpanishPresent = "regreso",
                examplePast = "She got back her stolen wallet.",
                examplePastTranslation = "Ella recuperó su cartera robada.",
                highlightSpanishPast = "recuperó",
                exampleCommon = "He has gotten back to his normal routine.",
                exampleCommonTranslation = "Él ha regresado a su rutina normal.",
                highlightSpanishCommon = "ha regresado"
            ),

            PhrasalVerb(
                verb = "get by",
                translation = "arreglárselas / sobrevivir",
                usageContext = "Se usa para manejar una situación difícil con recursos limitados.",
                examplePresent = "We get by on a modest income.",
                examplePresentTranslation = "Nosotros nos arreglamos con un ingreso modesto.",
                highlightSpanishPresent = "nos arreglamos",
                examplePast = "They got by with very little during the crisis.",
                examplePastTranslation = "Ellos se las arreglaron con muy poco durante la crisis.",
                highlightSpanishPast = "se las arreglaron",
                exampleCommon = "I have gotten by with help from friends.",
                exampleCommonTranslation = "Yo me he arreglado con ayuda de amigos.",
                highlightSpanishCommon = "me he arreglado"
            ),

            PhrasalVerb(
                verb = "get in",
                translation = "entrar (vehículo) / llegar",
                usageContext = "Se usa para:\n• Entrar a un vehículo\n• Llegar a un lugar\n• Ser aceptado (en una institución)",
                examplePresent = "Students get in the school bus here.",
                examplePresentTranslation = "Los estudiantes entran al autobús escolar aquí.",
                highlightSpanishPresent = "entran",
                examplePast = "He got in the car and drove away.",
                examplePastTranslation = "Él entró al coche y se fue.",
                highlightSpanishPast = "entró",
                exampleCommon = "She has gotten in to her first choice university.",
                exampleCommonTranslation = "Ella ha sido aceptada en su universidad de primera elección.",
                highlightSpanishCommon = "ha sido aceptada"
            ),

            PhrasalVerb(
                verb = "get off",
                translation = "bajarse (transporte)",
                usageContext = "Se usa específicamente para bajarse de medios de transporte.",
                examplePresent = "I get off the bus at this stop.",
                examplePresentTranslation = "Yo me bajo del autobús en esta parada.",
                highlightSpanishPresent = "me bajo",
                examplePast = "They got off the train at the central station.",
                examplePastTranslation = "Ellos se bajaron del tren en la estación central.",
                highlightSpanishPast = "se bajaron",
                exampleCommon = "We have gotten off at the wrong stop before.",
                exampleCommonTranslation = "Nosotros nos hemos bajado en la parada equivocada antes.",
                highlightSpanishCommon = "nos hemos bajado"
            ),

            PhrasalVerb(
                verb = "get on",
                translation = "subirse (transporte) / llevarse bien",
                usageContext = "Se usa para:\n• Subir a medios de transporte\n• Tener buena relación con alguien",
                examplePresent = "We get on the subway every morning.",
                examplePresentTranslation = "Nosotros nos subimos al metro cada mañana.",
                highlightSpanishPresent = "nos subimos",
                examplePast = "She got on well with her new roommate.",
                examplePastTranslation = "Ella se llevó bien con su nueva compañera de cuarto.",
                highlightSpanishPast = "se llevó",
                exampleCommon = "They have gotten on the same flight.",
                exampleCommonTranslation = "Ellos se han subido al mismo vuelo.",
                highlightSpanishCommon = "se han subido"
            ),

            PhrasalVerb(
                verb = "get out",
                translation = "salir / sacar",
                usageContext = "Se usa para:\n• Salir de un lugar cerrado\n• Extraer o remover algo",
                examplePresent = "We get out of work at 5 PM.",
                examplePresentTranslation = "Nosotros salimos del trabajo a las 5 PM.",
                highlightSpanishPresent = "salimos",
                examplePast = "He got out of the car quickly.",
                examplePastTranslation = "Él salió del coche rápidamente.",
                highlightSpanishPast = "salió",
                exampleCommon = "I have gotten out all the old clothes.",
                exampleCommonTranslation = "Yo he sacado toda la ropa vieja.",
                highlightSpanishCommon = "he sacado"
            ),

            PhrasalVerb(
                verb = "get over",
                translation = "superar / recuperarse",
                usageContext = "Se usa para superar enfermedades, emociones o problemas.",
                examplePresent = "People get over colds in about a week.",
                examplePresentTranslation = "Las personas se recuperan de los resfriados en una semana.",
                highlightSpanishPresent = "se recuperan",
                examplePast = "She got over her fear of public speaking.",
                examplePastTranslation = "Ella superó su miedo a hablar en público.",
                highlightSpanishPast = "superó",
                exampleCommon = "He has gotten over the breakup completely.",
                exampleCommonTranslation = "Él se ha recuperado de la ruptura completamente.",
                highlightSpanishCommon = "se ha recuperado"
            ),

            PhrasalVerb(
                verb = "get through",
                translation = "superar / completar",
                usageContext = "Se usa para:\n• Terminar algo difícil\n• Sobrevivir un período difícil\n• Comunicarse por teléfono",
                examplePresent = "Students get through exams with hard work.",
                examplePresentTranslation = "Los estudiantes superan los exámenes con trabajo duro.",
                highlightSpanishPresent = "superan",
                examplePast = "We got through the winter without heating problems.",
                examplePastTranslation = "Nosotros pasamos el invierno sin problemas de calefacción.",
                highlightSpanishPast = "pasamos",
                exampleCommon = "She has gotten through to the manager finally.",
                exampleCommonTranslation = "Ella se ha comunicado con el gerente finalmente.",
                highlightSpanishCommon = "se ha comunicado"
            ),

            PhrasalVerb(
                verb = "get together",
                translation = "reunirse / juntarse",
                usageContext = "Se usa para encuentros sociales o reuniones de personas.",
                examplePresent = "Friends get together every weekend.",
                examplePresentTranslation = "Los amigos se reúnen cada fin de semana.",
                highlightSpanishPresent = "se reúnen",
                examplePast = "We got together for a family dinner.",
                examplePastTranslation = "Nosotros nos reunimos para una cena familiar.",
                highlightSpanishPast = "nos reunimos",
                exampleCommon = "They have gotten together many times this year.",
                exampleCommonTranslation = "Ellos se han reunido muchas veces este año.",
                highlightSpanishCommon = "se han reunido"
            ),

            PhrasalVerb(
                verb = "get up",
                translation = "levantarse",
                usageContext = "Se usa para levantarse de:\n• La cama por la mañana\n• Una silla después de sentarse\n• Después de caerse",
                examplePresent = "I get up at 7 AM every day.",
                examplePresentTranslation = "Yo me levanto a las 7 AM cada día.",
                highlightSpanishPresent = "levanto",
                examplePast = "He got up late this morning.",
                examplePastTranslation = "Él se levantó tarde esta mañana.",
                highlightSpanishPast = "levantó",
                exampleCommon = "We have gotten up early all week.",
                exampleCommonTranslation = "Nosotros nos hemos levantado temprano toda la semana.",
                highlightSpanishCommon = "levantado"
            ),

            PhrasalVerb(
                verb = "give away",
                translation = "regalar / revelar",
                usageContext = "Se usa para:\n• Dar algo sin pedir dinero\n• Revelar un secreto o información",
                examplePresent = "I give away old clothes to charity.",
                examplePresentTranslation = "Yo regalo ropa vieja a la caridad.",
                highlightSpanishPresent = "regalo",
                examplePast = "She gave away the ending of the movie.",
                examplePastTranslation = "Ella reveló el final de la película.",
                highlightSpanishPast = "reveló",
                exampleCommon = "He has given away all his books.",
                exampleCommonTranslation = "Él ha regalado todos sus libros.",
                highlightSpanishCommon = "ha regalado"
            ),

            PhrasalVerb(
                verb = "give back",
                translation = "devolver",
                usageContext = "Se usa para retornar algo que fue prestado o tomado.",
                examplePresent = "Borrowers should give back books on time.",
                examplePresentTranslation = "Los prestatarios deben devolver los libros a tiempo.",
                highlightSpanishPresent = "devolver",
                examplePast = "I gave back the money I owed.",
                examplePastTranslation = "Yo devolví el dinero que debía.",
                highlightSpanishPast = "devolví",
                exampleCommon = "She has given back everything she borrowed.",
                exampleCommonTranslation = "Ella ha devuelto todo lo que pidió prestado.",
                highlightSpanishCommon = "ha devuelto"
            ),

            PhrasalVerb(
                verb = "give in",
                translation = "rendirse / ceder",
                usageContext = "Se usa para dejar de resistir o aceptar algo contra la voluntad.",
                examplePresent = "Children often give in when they're tired.",
                examplePresentTranslation = "Los niños a menudo se rinden cuando están cansados.",
                highlightSpanishPresent = "se rinden",
                examplePast = "He gave in to their demands.",
                examplePastTranslation = "Él cedió a sus demandas.",
                highlightSpanishPast = "cedió",
                exampleCommon = "They have given in after long negotiations.",
                exampleCommonTranslation = "Ellos han cedido después de largas negociaciones.",
                highlightSpanishCommon = "han cedido"
            ),

            PhrasalVerb(
                verb = "give up",
                translation = "rendirse / abandonar",
                usageContext = "Se usa para:\n• Dejar de intentar algo\n• Abandonar un hábito\n• Renunciar a algo",
                examplePresent = "I never give up on difficult tasks.",
                examplePresentTranslation = "Yo nunca me rindo en tareas difíciles.",
                highlightSpanishPresent = "me rindo",
                examplePast = "She gave up smoking last year.",
                examplePastTranslation = "Ella dejó de fumar el año pasado.",
                highlightSpanishPast = "dejó",
                exampleCommon = "He has given up trying to convince them.",
                exampleCommonTranslation = "Él ha renunciado a tratar de convencerlos.",
                highlightSpanishCommon = "ha renunciado"
            ),

            PhrasalVerb(
                verb = "go ahead",
                translation = "adelante / proceder",
                usageContext = "Se usa para dar permiso o animar a alguien a hacer algo.",
                examplePresent = "Please go ahead and start without me.",
                examplePresentTranslation = "Por favor, adelante y comienza sin mí.",
                highlightSpanishPresent = "adelante",
                examplePast = "He went ahead with the plan despite objections.",
                examplePastTranslation = "Él procedió con el plan a pesar de las objeciones.",
                highlightSpanishPast = "procedió",
                exampleCommon = "They have gone ahead and booked the venue.",
                exampleCommonTranslation = "Ellos han procedido y reservado el lugar.",
                highlightSpanishCommon = "han procedido"
            ),

            PhrasalVerb(
                verb = "go away",
                translation = "irse / marcharse",
                usageContext = "Se usa para pedir o describir que alguien se va de un lugar.",
                examplePresent = "Tourists go away after the summer season.",
                examplePresentTranslation = "Los turistas se van después de la temporada de verano.",
                highlightSpanishPresent = "se van",
                examplePast = "The pain went away after taking medicine.",
                examplePastTranslation = "El dolor se fue después de tomar medicina.",
                highlightSpanishPast = "se fue",
                exampleCommon = "He has gone away on a business trip.",
                exampleCommonTranslation = "Él se ha ido de viaje de negocios.",
                highlightSpanishCommon = "se ha ido"
            ),

            PhrasalVerb(
                verb = "go back",
                translation = "volver / regresar",
                usageContext = "Se usa para retornar a un lugar donde se estuvo antes.",
                examplePresent = "We go back to our hometown every Christmas.",
                examplePresentTranslation = "Nosotros volvemos a nuestra ciudad natal cada Navidad.",
                highlightSpanishPresent = "volvemos",
                examplePast = "She went back to school to study more.",
                examplePastTranslation = "Ella volvió a la escuela para estudiar más.",
                highlightSpanishPast = "volvió",
                exampleCommon = "They have gone back to their old habits.",
                exampleCommonTranslation = "Ellos han vuelto a sus viejos hábitos.",
                highlightSpanishCommon = "han vuelto"
            ),

            PhrasalVerb(
                verb = "go by",
                translation = "pasar (tiempo) / pasar por",
                usageContext = "Se usa para:\n• Tiempo que transcurre\n• Pasar cerca de un lugar\n• Seguir reglas o instrucciones",
                examplePresent = "Years go by faster as you get older.",
                examplePresentTranslation = "Los años pasan más rápido a medida que envejeces.",
                highlightSpanishPresent = "pasan",
                examplePast = "He went by my house yesterday.",
                examplePastTranslation = "Él pasó por mi casa ayer.",
                highlightSpanishPast = "pasó",
                exampleCommon = "Time has gone by so quickly this year.",
                exampleCommonTranslation = "El tiempo ha pasado tan rápido este año.",
                highlightSpanishCommon = "ha pasado"
            ),

            PhrasalVerb(
                verb = "go down",
                translation = "bajar / disminuir",
                usageContext = "Se usa para:\n• Descender físicamente\n• Disminuir en cantidad o valor\n• Ser recordado (en historia)",
                examplePresent = "Prices go down during sales.",
                examplePresentTranslation = "Los precios bajan durante las rebajas.",
                highlightSpanishPresent = "bajan",
                examplePast = "The sun went down at 6 PM.",
                examplePastTranslation = "El sol se puso a las 6 PM.",
                highlightSpanishPast = "se puso",
                exampleCommon = "Stock values have gone down significantly.",
                exampleCommonTranslation = "Los valores de las acciones han disminuido significativamente.",
                highlightSpanishCommon = "han disminuido"
            ),

            PhrasalVerb(
                verb = "go for",
                translation = "ir por / intentar obtener",
                usageContext = "Se usa para:\n• Elegir o seleccionar algo\n• Intentar lograr algo\n• Atacar verbal o físicamente",
                examplePresent = "I usually go for the vegetarian option.",
                examplePresentTranslation = "Yo usualmente voy por la opción vegetariana.",
                highlightSpanishPresent = "voy por",
                examplePast = "She went for the job and got it.",
                examplePastTranslation = "Ella intentó obtener el trabajo y lo consiguió.",
                highlightSpanishPast = "intentó obtener",
                exampleCommon = "He has gone for a promotion at work.",
                exampleCommonTranslation = "Él ha intentado obtener un ascenso en el trabajo.",
                highlightSpanishCommon = "ha intentado obtener"
            ),

            PhrasalVerb(
                verb = "go off",
                translation = "sonar (alarma) / caducar",
                usageContext = "Se usa para:\n• Alarmas o relojes que suenan\n• Comida que se echa a perder\n• Explosiones o disparos",
                examplePresent = "The fire alarm goes off during tests.",
                examplePresentTranslation = "La alarma de incendios suena durante las pruebas.",
                highlightSpanishPresent = "suena",
                examplePast = "The milk went off because it wasn't refrigerated.",
                examplePastTranslation = "La leche se echó a perder porque no estaba refrigerada.",
                highlightSpanishPast = "se echó a perder",
                exampleCommon = "The fireworks have gone off beautifully.",
                exampleCommonTranslation = "Los fuegos artificiales han explotado bellamente.",
                highlightSpanishCommon = "han explotado"
            ),

            PhrasalVerb(
                verb = "go on",
                translation = "continuar / suceder",
                usageContext = "Se usa para:\n• Continuar con una acción\n• Eventos que están ocurriendo\n• Durar o persistir",
                examplePresent = "The show goes on despite the rain.",
                examplePresentTranslation = "El espectáculo continúa a pesar de la lluvia.",
                highlightSpanishPresent = "continúa",
                examplePast = "What went on here last night?",
                examplePastTranslation = "¿Qué sucedió aquí anoche?",
                highlightSpanishPast = "sucedió",
                exampleCommon = "This discussion has gone on for too long.",
                exampleCommonTranslation = "Esta discusión ha continuado por demasiado tiempo.",
                highlightSpanishCommon = "ha continuado"
            ),

            PhrasalVerb(
                verb = "go out",
                translation = "salir (socialmente) / apagarse",
                usageContext = "Se usa para:\n• Salir a divertirse\n• Luces o fuego que se apagan\n• Dejar de estar de moda",
                examplePresent = "We go out for dinner every Friday.",
                examplePresentTranslation = "Nosotros salimos a cenar cada viernes.",
                highlightSpanishPresent = "salimos",
                examplePast = "The lights went out during the storm.",
                examplePastTranslation = "Las luces se apagaron durante la tormenta.",
                highlightSpanishPast = "se apagaron",
                exampleCommon = "They have gone out together many times.",
                exampleCommonTranslation = "Ellos han salido juntos muchas veces.",
                highlightSpanishCommon = "han salido"
            ),

            PhrasalVerb(
                verb = "go over",
                translation = "repasar / revisar",
                usageContext = "Se usa para examinar o revisar algo cuidadosamente.",
                examplePresent = "Teachers go over the material before exams.",
                examplePresentTranslation = "Los profesores repasan el material antes de los exámenes.",
                highlightSpanishPresent = "repasan",
                examplePast = "We went over the contract line by line.",
                examplePastTranslation = "Nosotros revisamos el contrato línea por línea.",
                highlightSpanishPast = "revisamos",
                exampleCommon = "She has gone over her notes several times.",
                exampleCommonTranslation = "Ella ha repasado sus notas varias veces.",
                highlightSpanishCommon = "ha repasado"
            ),

            PhrasalVerb(
                verb = "go through",
                translation = "pasar por / experimentar",
                usageContext = "Se usa para:\n• Experimentar situaciones difíciles\n• Examinar cuidadosamente\n• Gastar o usar completamente",
                examplePresent = "Many people go through financial difficulties.",
                examplePresentTranslation = "Muchas personas pasan por dificultades financieras.",
                highlightSpanishPresent = "pasan por",
                examplePast = "He went through all his savings.",
                examplePastTranslation = "Él gastó todos sus ahorros.",
                highlightSpanishPast = "gastó",
                exampleCommon = "She has gone through a lot this year.",
                exampleCommonTranslation = "Ella ha pasado por mucho este año.",
                highlightSpanishCommon = "ha pasado por"
            ),

            PhrasalVerb(
                verb = "go up",
                translation = "subir / aumentar",
                usageContext = "Se usa para:\n• Ascender físicamente\n• Aumentar en cantidad o valor\n• Ser construido (edificios)",
                examplePresent = "Prices go up every year.",
                examplePresentTranslation = "Los precios suben cada año.",
                highlightSpanishPresent = "suben",
                examplePast = "The temperature went up suddenly.",
                examplePastTranslation = "La temperatura subió repentinamente.",
                highlightSpanishPast = "subió",
                exampleCommon = "New buildings have gone up in the area.",
                exampleCommonTranslation = "Nuevos edificios se han construido en el área.",
                highlightSpanishCommon = "se han construido"
            ),

            PhrasalVerb(
                verb = "grow up",
                translation = "crecer (personas)",
                usageContext = "Se usa específicamente para el proceso de madurar de niño a adulto.",
                examplePresent = "Children grow up so fast these days.",
                examplePresentTranslation = "Los niños crecen tan rápido estos días.",
                highlightSpanishPresent = "crecen",
                examplePast = "He grew up in a small town.",
                examplePastTranslation = "Él creció en un pueblo pequeño.",
                highlightSpanishPast = "creció",
                exampleCommon = "We have grown up with these traditions.",
                exampleCommonTranslation = "Nosotros hemos crecido con estas tradiciones.",
                highlightSpanishCommon = "hemos crecido"
            ),

            PhrasalVerb(
                verb = "hand in",
                translation = "entregar",
                usageContext = "Se usa para entregar documentos, tareas o trabajos formalmente.",
                examplePresent = "Students hand in their homework on Monday.",
                examplePresentTranslation = "Los estudiantes entregan su tarea los lunes.",
                highlightSpanishPresent = "entregan",
                examplePast = "I handed in my resignation yesterday.",
                examplePastTranslation = "Yo entregué mi renuncia ayer.",
                highlightSpanishPast = "entregué",
                exampleCommon = "She has handed in all the required forms.",
                exampleCommonTranslation = "Ella ha entregado todos los formularios requeridos.",
                highlightSpanishCommon = "ha entregado"
            ),

            PhrasalVerb(
                verb = "hand out",
                translation = "repartir / distribuir",
                usageContext = "Se usa para distribuir cosas a un grupo de personas.",
                examplePresent = "Volunteers hand out food to the homeless.",
                examplePresentTranslation = "Los voluntarios reparten comida a las personas sin hogar.",
                highlightSpanishPresent = "reparten",
                examplePast = "The teacher handed out the exam papers.",
                examplePastTranslation = "El profesor repartió los exámenes.",
                highlightSpanishPast = "repartió",
                exampleCommon = "They have handed out all the flyers.",
                exampleCommonTranslation = "Ellos han repartido todos los volantes.",
                highlightSpanishCommon = "han repartido"
            ),

            PhrasalVerb(
                verb = "hang on",
                translation = "esperar / agarrarse",
                usageContext = "Se usa para:\n• Pedir a alguien que espere\n• Agarrarse físicamente a algo",
                examplePresent = "Please hang on while I check the information.",
                examplePresentTranslation = "Por favor, espera mientras reviso la información.",
                highlightSpanishPresent = "espera",
                examplePast = "He hung on to the railing tightly.",
                examplePastTranslation = "Él se agarró a la barandilla firmemente.",
                highlightSpanishPast = "se agarró",
                exampleCommon = "I have hung on for ten minutes already.",
                exampleCommonTranslation = "Yo he esperado por diez minutos ya.",
                highlightSpanishCommon = "he esperado"
            ),

            PhrasalVerb(
                verb = "hang out",
                translation = "pasar el rato",
                usageContext = "Se usa para tiempo social informal con amigos.",
                examplePresent = "Teenagers hang out at the mall.",
                examplePresentTranslation = "Los adolescentes pasan el rato en el centro comercial.",
                highlightSpanishPresent = "pasan el rato",
                examplePast = "We hung out at the park yesterday.",
                examplePastTranslation = "Nosotros pasamos el rato en el parque ayer.",
                highlightSpanishPast = "pasamos el rato",
                exampleCommon = "They have hung out together since childhood.",
                exampleCommonTranslation = "Ellos han pasado el rato juntos desde la infancia.",
                highlightSpanishCommon = "han pasado el rato"
            ),

            PhrasalVerb(
                verb = "hang up",
                translation = "colgar (teléfono)",
                usageContext = "Se usa específicamente para terminar una llamada telefónica.",
                examplePresent = "Some people hang up without saying goodbye.",
                examplePresentTranslation = "Algunas personas cuelgan sin decir adiós.",
                highlightSpanishPresent = "cuelgan",
                examplePast = "She hung up when she heard the news.",
                examplePastTranslation = "Ella colgó cuando escuchó las noticias.",
                highlightSpanishPast = "colgó",
                exampleCommon = "He has hung up on me several times.",
                exampleCommonTranslation = "Él me ha colgado varias veces.",
                highlightSpanishCommon = "ha colgado"
            ),

            PhrasalVerb(
                verb = "hold on",
                translation = "esperar / aguantar",
                usageContext = "Se usa para:\n• Pedir a alguien que espere\n• Agarrarse o mantenerse firme",
                examplePresent = "Hold on, I'll be right back.",
                examplePresentTranslation = "Espera, ya vuelvo.",
                highlightSpanishPresent = "Espera",
                examplePast = "He held on to his beliefs strongly.",
                examplePastTranslation = "Él se aferró a sus creencias firmemente.",
                highlightSpanishPast = "se aferró",
                exampleCommon = "We have held on through difficult times.",
                exampleCommonTranslation = "Nosotros hemos aguantado en tiempos difíciles.",
                highlightSpanishCommon = "hemos aguantado"
            ),

            PhrasalVerb(
                verb = "hurry up",
                translation = "darse prisa",
                usageContext = "Se usa para pedir o indicar que alguien debe actuar más rápido.",
                examplePresent = "We always hurry up in the morning.",
                examplePresentTranslation = "Nosotros siempre nos damos prisa por la mañana.",
                highlightSpanishPresent = "nos damos prisa",
                examplePast = "They hurried up to catch the bus.",
                examplePastTranslation = "Ellos se dieron prisa para alcanzar el autobús.",
                highlightSpanishPast = "se dieron prisa",
                exampleCommon = "I have hurried up as much as possible.",
                exampleCommonTranslation = "Yo me he dado prisa tanto como sea posible.",
                highlightSpanishCommon = "me he dado prisa"
            ),

            PhrasalVerb(
                verb = "keep on",
                translation = "continuar / seguir",
                usageContext = "Se usa para persistir en una acción o comportamiento.",
                examplePresent = "He keeps on trying despite failures.",
                examplePresentTranslation = "Él continúa intentando a pesar de los fracasos.",
                highlightSpanishPresent = "continúa",
                examplePast = "She kept on talking for an hour.",
                examplePastTranslation = "Ella continuó hablando por una hora.",
                highlightSpanishPast = "continuó",
                exampleCommon = "They have kept on working all night.",
                exampleCommonTranslation = "Ellos han continuado trabajando toda la noche.",
                highlightSpanishCommon = "han continuado"
            ),

            PhrasalVerb(
                verb = "keep up",
                translation = "mantener el ritmo / continuar",
                usageContext = "Se usa para:\n• Mantener el mismo ritmo que otros\n• Continuar con un esfuerzo\n• Mantener algo en buen estado",
                examplePresent = "I keep up with the latest news.",
                examplePresentTranslation = "Yo me mantengo al día con las últimas noticias.",
                highlightSpanishPresent = "me mantengo",
                examplePast = "She kept up her studies while working.",
                examplePastTranslation = "Ella mantuvo sus estudios mientras trabajaba.",
                highlightSpanishPast = "mantuvo",
                exampleCommon = "He has kept up the good work.",
                exampleCommonTranslation = "Él ha mantenido el buen trabajo.",
                highlightSpanishCommon = "ha mantenido"
            ),

            PhrasalVerb(
                verb = "kick off",
                translation = "empezar / comenzar",
                usageContext = "Se usa para:\n• Iniciar eventos o reuniones\n• Comenzar un partido de fútbol\n• Empezar una discusión",
                examplePresent = "The conference kicks off at 9 AM.",
                examplePresentTranslation = "La conferencia comienza a las 9 AM.",
                highlightSpanishPresent = "comienza",
                examplePast = "The meeting kicked off with introductions.",
                examplePastTranslation = "La reunión comenzó con presentaciones.",
                highlightSpanishPast = "comenzó",
                exampleCommon = "The tournament has kicked off successfully.",
                exampleCommonTranslation = "El torneo ha comenzado exitosamente.",
                highlightSpanishCommon = "ha comenzado"
            ),

            PhrasalVerb(
                verb = "lay off",
                translation = "despedir (temporalmente)",
                usageContext = "Se usa específicamente para despidos temporales de empleo.",
                examplePresent = "Companies sometimes lay off workers during crises.",
                examplePresentTranslation = "Las compañías a veces despiden trabajadores durante crisis.",
                highlightSpanishPresent = "despiden",
                examplePast = "The factory laid off 100 employees.",
                examplePastTranslation = "La fábrica despidió a 100 empleados.",
                highlightSpanishPast = "despidió",
                exampleCommon = "Many people have been laid off recently.",
                exampleCommonTranslation = "Muchas personas han sido despedidas recientemente.",
                highlightSpanishCommon = "han sido despedidas"
            ),

            PhrasalVerb(
                verb = "leave out",
                translation = "omitir / excluir",
                usageContext = "Se usa para no incluir algo o a alguien.",
                examplePresent = "Some recipes leave out sugar for health reasons.",
                examplePresentTranslation = "Algunas recetas omiten el azúcar por razones de salud.",
                highlightSpanishPresent = "omit",
                examplePast = "He left out important details from the report.",
                examplePastTranslation = "Él omitió detalles importantes del informe.",
                highlightSpanishPast = "omitió",
                exampleCommon = "She has left out her name from the list.",
                exampleCommonTranslation = "Ella ha excluido su nombre de la lista.",
                highlightSpanishCommon = "ha excluido"
            ),

            PhrasalVerb(
                verb = "let down",
                translation = "decepcionar / fallar",
                usageContext = "Se usa para decepcionar a alguien que confía en ti.",
                examplePresent = "I never let down my friends when they need me.",
                examplePresentTranslation = "Yo nunca decepciono a mis amigos cuando me necesitan.",
                highlightSpanishPresent = "decepciono",
                examplePast = "He let down the whole team with his absence.",
                examplePastTranslation = "Él decepcionó a todo el equipo con su ausencia.",
                highlightSpanishPast = "decepcionó",
                exampleCommon = "She has never let me down before.",
                exampleCommonTranslation = "Ella nunca me ha decepcionado antes.",
                highlightSpanishCommon = "ha decepcionado"
            ),

            PhrasalVerb(
                verb = "look after",
                translation = "cuidar / atender",
                usageContext = "Se usa para cuidar personas, animales o cosas.",
                examplePresent = "Parents look after their children carefully.",
                examplePresentTranslation = "Los padres cuidan a sus hijos cuidadosamente.",
                highlightSpanishPresent = "cuidan",
                examplePast = "She looked after her sick neighbor.",
                examplePastTranslation = "Ella cuidó a su vecino enfermo.",
                highlightSpanishPast = "cuidó",
                exampleCommon = "I have looked after this house for years.",
                exampleCommonTranslation = "Yo he cuidado esta casa por años.",
                highlightSpanishCommon = "he cuidado"
            ),

            PhrasalVerb(
                verb = "look around",
                translation = "mirar alrededor / recorrer",
                usageContext = "Se usa para examinar un lugar o buscar algo visualmente.",
                examplePresent = "Tourists look around the city with curiosity.",
                examplePresentTranslation = "Los turistas recorren la ciudad con curiosidad.",
                highlightSpanishPresent = "recorren",
                examplePast = "We looked around the store but didn't buy anything.",
                examplePastTranslation = "Nosotros miramos alrededor en la tienda pero no compramos nada.",
                highlightSpanishPast = "miramos",
                exampleCommon = "He has looked around for his keys everywhere.",
                exampleCommonTranslation = "Él ha buscado sus llaves por todas partes.",
                highlightSpanishCommon = "ha buscado"
            ),

            PhrasalVerb(
                verb = "look at",
                translation = "mirar / observar",
                usageContext = "Se usa para dirigir la vista hacia algo o alguien.",
                examplePresent = "Students look at the board during class.",
                examplePresentTranslation = "Los estudiantes miran el pizarrón durante la clase.",
                highlightSpanishPresent = "miran",
                examplePast = "She looked at the painting for a long time.",
                examplePastTranslation = "Ella miró la pintura por mucho tiempo.",
                highlightSpanishPast = "miró",
                exampleCommon = "I have looked at all the options available.",
                exampleCommonTranslation = "Yo he mirado todas las opciones disponibles.",
                highlightSpanishCommon = "he mirado"
            ),

            PhrasalVerb(
                verb = "look for",
                translation = "buscar",
                usageContext = "Se usa para intentar encontrar algo o a alguien.",
                examplePresent = "I look for bargains when shopping.",
                examplePresentTranslation = "Yo busco gangas cuando compro.",
                highlightSpanishPresent = "busco",
                examplePast = "They looked for the missing dog all day.",
                examplePastTranslation = "Ellos buscaron al perro perdido todo el día.",
                highlightSpanishPast = "buscaron",
                exampleCommon = "We have looked for a solution for weeks.",
                exampleCommonTranslation = "Nosotros hemos buscado una solución por semanas.",
                highlightSpanishCommon = "hemos buscado"
            ),

            PhrasalVerb(
                verb = "look forward to",
                translation = "tener ilusión por / esperar con ansias",
                usageContext = "Se usa para expresar anticipación positiva por un evento futuro.",
                examplePresent = "I look forward to the weekend every week.",
                examplePresentTranslation = "Yo espero con ansias el fin de semana cada semana.",
                highlightSpanishPresent = "espero con ansias",
                examplePast = "She looked forward to her vacation for months.",
                examplePastTranslation = "Ella esperó con ansias sus vacaciones por meses.",
                highlightSpanishPast = "esperó con ansias",
                exampleCommon = "We have looked forward to this moment for years.",
                exampleCommonTranslation = "Nosotros hemos esperado este momento con ansias por años.",
                highlightSpanishCommon = "hemos esperado"
            ),

            PhrasalVerb(
                verb = "look into",
                translation = "investigar / examinar",
                usageContext = "Se usa para investigar o examinar un asunto o problema.",
                examplePresent = "The committee looks into complaints regularly.",
                examplePresentTranslation = "El comité investiga quejas regularmente.",
                highlightSpanishPresent = "investiga",
                examplePast = "Police looked into the incident thoroughly.",
                examplePastTranslation = "La policía investigó el incidente minuciosamente.",
                highlightSpanishPast = "investigó",
                exampleCommon = "They have looked into all possible causes.",
                exampleCommonTranslation = "Ellos han investigado todas las posibles causas.",
                highlightSpanishCommon = "han investigado"
            ),

            PhrasalVerb(
                verb = "look out",
                translation = "¡cuidado! / estar atento",
                usageContext = "Se usa para advertir de peligro o pedir atención.",
                examplePresent = "Look out! There's a car coming.",
                examplePresentTranslation = "¡Cuidado! Viene un coche.",
                highlightSpanishPresent = "Cuidado",
                examplePast = "She looked out for her younger brother.",
                examplePastTranslation = "Ella estuvo atenta a su hermano menor.",
                highlightSpanishPast = "estuvo atenta",
                exampleCommon = "We have looked out for each other always.",
                exampleCommonTranslation = "Nosotros nos hemos cuidado mutuamente siempre.",
                highlightSpanishCommon = "nos hemos cuidado"
            ),

            PhrasalVerb(
                verb = "look up",
                translation = "buscar (información) / mejorar",
                usageContext = "Se usa para:\n• Buscar información en libros o internet\n• Mejorar una situación\n• Mirar hacia arriba",
                examplePresent = "Students look up words in the dictionary.",
                examplePresentTranslation = "Los estudiantes buscan palabras en el diccionario.",
                highlightSpanishPresent = "buscan",
                examplePast = "Things looked up after he found a job.",
                examplePastTranslation = "Las cosas mejoraron después de que encontró trabajo.",
                highlightSpanishPast = "mejoraron",
                exampleCommon = "I have looked up that information already.",
                exampleCommonTranslation = "Yo ya he buscado esa información.",
                highlightSpanishCommon = "he buscado"
            ),

            PhrasalVerb(
                verb = "make out",
                translation = "distinguir / entender",
                usageContext = "Se usa para:\n• Ver o escuchar algo con dificultad\n• Comprender algo poco claro\n• Besarse apasionadamente (coloquial)",
                examplePresent = "I can't make out what this says.",
                examplePresentTranslation = "Yo no puedo distinguir lo que esto dice.",
                highlightSpanishPresent = "distinguir",
                examplePast = "She made out the shape in the darkness.",
                examplePastTranslation = "Ella distinguió la forma en la oscuridad.",
                highlightSpanishPast = "distinguí",
                exampleCommon = "We haven't made out the details yet.",
                exampleCommonTranslation = "Nosotros no hemos entendido los detalles todavía.",
                highlightSpanishCommon = "hemos entendido"
            ),

            PhrasalVerb(
                verb = "make up",
                translation = "inventar / reconciliarse / maquillarse",
                usageContext = "Se usa para:\n• Inventar historias o excusas\n• Reconciliarse después de una pelea\n• Aplicar maquillaje",
                examplePresent = "Children often make up imaginary friends.",
                examplePresentTranslation = "Los niños a menudo inventan amigos imaginarios.",
                highlightSpanishPresent = "inventan",
                examplePast = "They made up after their argument.",
                examplePastTranslation = "Ellos se reconciliaron después de su discusión.",
                highlightSpanishPast = "se reconciliaron",
                exampleCommon = "She has made up a convincing story.",
                exampleCommonTranslation = "Ella ha inventado una historia convincente.",
                highlightSpanishCommon = "ha inventado"
            ),

            PhrasalVerb(
                verb = "mix up",
                translation = "confundir / mezclar",
                usageContext = "Se usa para confundir una cosa con otra o mezclar desordenadamente.",
                examplePresent = "People often mix up these two words.",
                examplePresentTranslation = "Las personas a menudo confunden estas dos palabras.",
                highlightSpanishPresent = "confunden",
                examplePast = "I mixed up the dates for the meetings.",
                examplePastTranslation = "Yo confundí las fechas de las reuniones.",
                highlightSpanishPast = "confundí",
                exampleCommon = "They have mixed up all the documents.",
                exampleCommonTranslation = "Ellos han mezclado todos los documentos.",
                highlightSpanishCommon = "han mezclado"
            ),

            PhrasalVerb(
                verb = "pass away",
                translation = "fallecer / morir",
                usageContext = "Se usa como una forma educada o suave de decir que alguien ha muerto.",
                examplePresent = "Many elderly people pass away in hospitals.",
                examplePresentTranslation = "Muchas personas mayores fallecen en hospitales.",
                highlightSpanishPresent = "fallecen",
                examplePast = "His grandfather passed away last year.",
                examplePastTranslation = "Su abuelo falleció el año pasado.",
                highlightSpanishPast = "falleció",
                exampleCommon = "Several famous actors have passed away recently.",
                exampleCommonTranslation = "Varios actores famosos han fallecido recientemente.",
                highlightSpanishCommon = "han fallecido"
            ),

            PhrasalVerb(
                verb = "pass out",
                translation = "desmayarse / repartir",
                usageContext = "Se usa para:\n• Perder el conocimiento\n• Distribuir cosas a un grupo",
                examplePresent = "Some people pass out at the sight of blood.",
                examplePresentTranslation = "Algunas personas se desmayan al ver sangre.",
                highlightSpanishPresent = "se desmayan",
                examplePast = "He passed out from exhaustion.",
                examplePastTranslation = "Él se desmayó por agotamiento.",
                highlightSpanishPast = "se desmayó",
                exampleCommon = "The teacher has passed out the exam papers.",
                exampleCommonTranslation = "El profesor ha repartido los exámenes.",
                highlightSpanishCommon = "ha repartido"
            ),

            PhrasalVerb(
                verb = "pay back",
                translation = "devolver (dinero) / vengarse",
                usageContext = "Se usa para:\n• Devolver dinero prestado\n• Tomar venganza por algo",
                examplePresent = "Borrowers should pay back loans promptly.",
                examplePresentTranslation = "Los prestatarios deben devolver los préstamos prontamente.",
                highlightSpanishPresent = "devolver",
                examplePast = "I paid back the money I owed.",
                examplePastTranslation = "Yo devolví el dinero que debía.",
                highlightSpanishPast = "devolví",
                exampleCommon = "He has paid back all his debts.",
                exampleCommonTranslation = "Él ha devuelto todas sus deudas.",
                highlightSpanishCommon = "ha devuelto"
            ),

            PhrasalVerb(
                verb = "pick out",
                translation = "elegir / seleccionar",
                usageContext = "Se usa para seleccionar algo específico entre varias opciones.",
                examplePresent = "Customers pick out fruits carefully at the market.",
                examplePresentTranslation = "Los clientes eligen frutas cuidadosamente en el mercado.",
                highlightSpanishPresent = "eligen",
                examplePast = "She picked out a dress for the party.",
                examplePastTranslation = "Ella eligió un vestido para la fiesta.",
                highlightSpanishPast = "eligió",
                exampleCommon = "We have picked out the best candidates.",
                exampleCommonTranslation = "Nosotros hemos seleccionado los mejores candidatos.",
                highlightSpanishCommon = "hemos seleccionado"
            ),

            PhrasalVerb(
                verb = "pick up",
                translation = "recoger / aprender",
                usageContext = "Se usa para:\n• Recoger objetos o personas\n• Aprender habilidades informalmente\n• Mejorar o aumentar",
                examplePresent = "I pick up my daughter from school daily.",
                examplePresentTranslation = "Yo recojo a mi hija de la escuela diariamente.",
                highlightSpanishPresent = "recojo",
                examplePast = "He picked up Spanish while living in Mexico.",
                examplePastTranslation = "Él aprendió español mientras vivía en México.",
                highlightSpanishPast = "aprendió",
                exampleCommon = "Business has picked up this quarter.",
                exampleCommonTranslation = "Los negocios han mejorado este trimestre.",
                highlightSpanishCommon = "han mejorado"
            ),

            PhrasalVerb(
                verb = "point out",
                translation = "señalar / indicar",
                usageContext = "Se usa para llamar la atención sobre algo específico.",
                examplePresent = "Guides point out important landmarks.",
                examplePresentTranslation = "Los guías señalan puntos de referencia importantes.",
                highlightSpanishPresent = "señalan",
                examplePast = "She pointed out the error in the calculation.",
                examplePastTranslation = "Ella señaló el error en el cálculo.",
                highlightSpanishPast = "señaló",
                exampleCommon = "I have pointed out that issue several times.",
                exampleCommonTranslation = "Yo he señalado ese problema varias veces.",
                highlightSpanishCommon = "he señalado"
            ),

            PhrasalVerb(
                verb = "put away",
                translation = "guardar / guardar en su lugar",
                usageContext = "Se usa para colocar cosas en su lugar designado después de usarlas.",
                examplePresent = "Children should put away their toys.",
                examplePresentTranslation = "Los niños deben guardar sus juguetes.",
                highlightSpanishPresent = "guardar",
                examplePast = "She put away the groceries in the kitchen.",
                examplePastTranslation = "Ella guardó las compras en la cocina.",
                highlightSpanishPast = "guardó",
                exampleCommon = "We have put away the winter clothes.",
                exampleCommonTranslation = "Nosotros hemos guardado la ropa de invierno.",
                highlightSpanishCommon = "hemos guardado"
            ),

            PhrasalVerb(
                verb = "put off",
                translation = "posponer / aplazar",
                usageContext = "Se usa para retrasar o posponer algo para más tarde.",
                examplePresent = "People often put off difficult tasks.",
                examplePresentTranslation = "Las personas a menudo posponen tareas difíciles.",
                highlightSpanishPresent = "posponen",
                examplePast = "We put off the meeting until next week.",
                examplePastTranslation = "Nosotros pospusimos la reunión hasta la próxima semana.",
                highlightSpanishPast = "pospusimos",
                exampleCommon = "He has put off making a decision.",
                exampleCommonTranslation = "Él ha pospuesto tomar una decisión.",
                highlightSpanishCommon = "ha pospuesto"
            ),

            PhrasalVerb(
                verb = "put on",
                translation = "ponerse (ropa) / encender",
                usageContext = "Se usa para:\n• Vestirse con ropa o accesorios\n• Encender dispositivos eléctricos\n• Aumentar de peso",
                examplePresent = "I put on a coat when it's cold.",
                examplePresentTranslation = "Yo me pongo un abrigo cuando hace frío.",
                highlightSpanishPresent = "me pongo",
                examplePast = "She put on her glasses to read.",
                examplePastTranslation = "Ella se puso sus lentes para leer.",
                highlightSpanishPast = "se puso",
                exampleCommon = "He has put on some weight recently.",
                exampleCommonTranslation = "Él ha subido de peso recientemente.",
                highlightSpanishCommon = "ha subido"
            ),

            PhrasalVerb(
                verb = "put out",
                translation = "apagar / extinguir",
                usageContext = "Se usa para:\n• Apagar fuegos o llamas\n• Sacar algo para que otros lo usen\n• Molestar o inconvenienciar",
                examplePresent = "Firefighters put out fires quickly.",
                examplePresentTranslation = "Los bomberos apagan incendios rápidamente.",
                highlightSpanishPresent = "apagan",
                examplePast = "He put out the candle before sleeping.",
                examplePastTranslation = "Él apagó la vela antes de dormir.",
                highlightSpanishPast = "apagó",
                exampleCommon = "We have put out all the chairs for the event.",
                exampleCommonTranslation = "Nosotros hemos sacado todas las sillas para el evento.",
                highlightSpanishCommon = "hemos sacado"
            ),

            PhrasalVerb(
                verb = "put up",
                translation = "colgar / alojar",
                usageContext = "Se usa para:\n• Colgar cuadros o decoraciones\n• Alojar a visitantes\n• Tolerar o aguantar",
                examplePresent = "We put up Christmas decorations in December.",
                examplePresentTranslation = "Nosotros colgamos decoraciones navideñas en diciembre.",
                highlightSpanishPresent = "colgamos",
                examplePast = "They put up their friends for the weekend.",
                examplePastTranslation = "Ellos alojaron a sus amigos por el fin de semana.",
                highlightSpanishPast = "alojaron",
                exampleCommon = "I have put up with this situation for too long.",
                exampleCommonTranslation = "Yo he aguantado esta situación por demasiado tiempo.",
                highlightSpanishCommon = "he aguantado"
            ),

            PhrasalVerb(
                verb = "run away",
                translation = "huir / escaparse",
                usageContext = "Se usa para dejar un lugar rápidamente, especialmente para escapar.",
                examplePresent = "Children sometimes run away from home.",
                examplePresentTranslation = "Los niños a veces huyen de casa.",
                highlightSpanishPresent = "huyen",
                examplePast = "The cat ran away when it saw the dog.",
                examplePastTranslation = "El gato huyó cuando vio al perro.",
                highlightSpanishPast = "huyó",
                exampleCommon = "He has run away from his problems.",
                exampleCommonTranslation = "Él ha huido de sus problemas.",
                highlightSpanishCommon = "ha huido"
            ),

            PhrasalVerb(
                verb = "run into",
                translation = "encontrarse con / chocar con",
                usageContext = "Se usa para:\n• Encontrar a alguien por casualidad\n• Chocar físicamente con algo\n• Enfrentar problemas",
                examplePresent = "I often run into old classmates downtown.",
                examplePresentTranslation = "Yo a menudo me encuentro con antiguos compañeros en el centro.",
                highlightSpanishPresent = "me encuentro",
                examplePast = "The car ran into a tree.",
                examplePastTranslation = "El coche chocó con un árbol.",
                highlightSpanishPast = "chocó",
                exampleCommon = "We have run into some difficulties.",
                exampleCommonTranslation = "Nosotros nos hemos encontrado con algunas dificultades.",
                highlightSpanishCommon = "nos hemos encontrado"
            ),

            PhrasalVerb(
                verb = "run out",
                translation = "agotarse / acabarse",
                usageContext = "Se usa para cuando algo se termina o se acaba.",
                examplePresent = "Supplies run out quickly during emergencies.",
                examplePresentTranslation = "Los suministros se agotan rápidamente durante emergencias.",
                highlightSpanishPresent = "se agotan",
                examplePast = "We ran out of milk yesterday.",
                examplePastTranslation = "Nosotros nos quedamos sin leche ayer.",
                highlightSpanishPast = "nos quedamos",
                exampleCommon = "Time has run out for this project.",
                exampleCommonTranslation = "El tiempo se ha agotado para este proyecto.",
                highlightSpanishCommon = "se ha agotado"
            ),

            PhrasalVerb(
                verb = "set off",
                translation = "partir / iniciar",
                usageContext = "Se usa para:\n• Comenzar un viaje\n• Activar una alarma o explosivo\n• Causar una reacción",
                examplePresent = "Travelers set off early in the morning.",
                examplePresentTranslation = "Los viajeros parten temprano en la mañana.",
                highlightSpanishPresent = "parten",
                examplePast = "They set off on their journey at dawn.",
                examplePastTranslation = "Ellos partieron en su viaje al amanecer.",
                highlightSpanishPast = "partieron",
                exampleCommon = "The fireworks have set off many car alarms.",
                exampleCommonTranslation = "Los fuegos artificiales han activado muchas alarmas de coches.",
                highlightSpanishCommon = "han activado"
            ),

            PhrasalVerb(
                verb = "set up",
                translation = "establecer / instalar",
                usageContext = "Se usa para:\n• Establecer un negocio o sistema\n• Instalar equipos o dispositivos\n• Preparar o organizar",
                examplePresent = "Entrepreneurs set up new companies regularly.",
                examplePresentTranslation = "Los emprendedores establecen nuevas compañías regularmente.",
                highlightSpanishPresent = "establecen",
                examplePast = "We set up the tent in 30 minutes.",
                examplePastTranslation = "Nosotros instalamos la tienda en 30 minutos.",
                highlightSpanishPast = "instalamos",
                exampleCommon = "She has set up a meeting for tomorrow.",
                exampleCommonTranslation = "Ella ha organizado una reunión para mañana.",
                highlightSpanishCommon = "ha organizado"
            ),

            PhrasalVerb(
                verb = "settle down",
                translation = "establecerse / calmarse",
                usageContext = "Se usa para:\n• Establecer una vida familiar estable\n• Calmarse después de excitación\n• Asentarse en un lugar",
                examplePresent = "Many people settle down after age 30.",
                examplePresentTranslation = "Muchas personas se establecen después de los 30 años.",
                highlightSpanishPresent = "se establecen",
                examplePast = "The children settled down after the story.",
                examplePastTranslation = "Los niños se calmaron después del cuento.",
                highlightSpanishPast = "se calmaron",
                exampleCommon = "They have settled down in the countryside.",
                exampleCommonTranslation = "Ellos se han establecido en el campo.",
                highlightSpanishCommon = "se han establecido"
            ),

            PhrasalVerb(
                verb = "show off",
                translation = "presumir / lucir",
                usageContext = "Se usa para exhibir habilidades o posesiones con orgullo, a veces de manera excesiva.",
                examplePresent = "Some people show off their new cars.",
                examplePresentTranslation = "Algunas personas presumen sus coches nuevos.",
                highlightSpanishPresent = "presumen",
                examplePast = "He showed off his cooking skills at the party.",
                examplePastTranslation = "Él lució sus habilidades culinarias en la fiesta.",
                highlightSpanishPast = "lució",
                exampleCommon = "She has shown off her awards many times.",
                exampleCommonTranslation = "Ella ha presumido sus premios muchas veces.",
                highlightSpanishCommon = "ha presumido"
            ),

            PhrasalVerb(
                verb = "show up",
                translation = "aparecer / llegar",
                usageContext = "Se usa para llegar a un lugar o evento, especialmente cuando se esperaba.",
                examplePresent = "Guests show up for the wedding on time.",
                examplePresentTranslation = "Los invitados llegan a la boda a tiempo.",
                highlightSpanishPresent = "llegan",
                examplePast = "He showed up late for the meeting.",
                examplePastTranslation = "Él llegó tarde a la reunión.",
                highlightSpanishPast = "llegó",
                exampleCommon = "Many people have shown up for the protest.",
                exampleCommonTranslation = "Muchas personas han aparecido para la protesta.",
                highlightSpanishCommon = "han aparecido"
            ),

            PhrasalVerb(
                verb = "shut down",
                translation = "cerrar (negocio) / apagar",
                usageContext = "Se usa para:\n• Cerrar permanentemente un negocio\n• Apagar máquinas o computadoras\n• Finalizar operaciones",
                examplePresent = "Some stores shut down during economic crises.",
                examplePresentTranslation = "Algunas tiendas cierran durante crisis económicas.",
                highlightSpanishPresent = "cierran",
                examplePast = "The factory shut down last year.",
                examplePastTranslation = "La fábrica cerró el año pasado.",
                highlightSpanishPast = "cerró",
                exampleCommon = "The computer has shut down unexpectedly.",
                exampleCommonTranslation = "La computadora se ha apagado inesperadamente.",
                highlightSpanishCommon = "se ha apagado"
            ),

            PhrasalVerb(
                verb = "shut up",
                translation = "callarse",
                usageContext = "Se usa para pedir a alguien que deje de hablar (puede ser considerado grosero).",
                examplePresent = "Sometimes teachers tell students to shut up.",
                examplePresentTranslation = "A veces los profesores les dicen a los estudiantes que se callen.",
                highlightSpanishPresent = "se callen",
                examplePast = "He told her to shut up during the movie.",
                examplePastTranslation = "Él le dijo que se callara durante la película.",
                highlightSpanishPast = "se callara",
                exampleCommon = "I have told him to shut up many times.",
                exampleCommonTranslation = "Yo le he dicho que se calle muchas veces.",
                highlightSpanishCommon = "he dicho"
            ),

            PhrasalVerb(
                verb = "sit down",
                translation = "sentarse",
                usageContext = "Se usa para tomar asiento o adoptar una posición sentada.",
                examplePresent = "Students sit down when the bell rings.",
                examplePresentTranslation = "Los estudiantes se sientan cuando suena el timbre.",
                highlightSpanishPresent = "se sientan",
                examplePast = "She sat down on the bench to rest.",
                examplePastTranslation = "Ella se sentó en la banca para descansar.",
                highlightSpanishPast = "se sentó",
                exampleCommon = "We have sat down to discuss the matter.",
                exampleCommonTranslation = "Nosotros nos hemos sentado a discutir el asunto.",
                highlightSpanishCommon = "nos hemos sentado"
            ),

            PhrasalVerb(
                verb = "slow down",
                translation = "reducir velocidad / ir más despacio",
                usageContext = "Se usa para:\n• Reducir la velocidad física\n• Disminuir el ritmo de actividad\n• Relajarse y tomar las cosas con calma",
                examplePresent = "Drivers slow down in school zones.",
                examplePresentTranslation = "Los conductores reducen velocidad en zonas escolares.",
                highlightSpanishPresent = "reducen",
                examplePast = "The economy slowed down last quarter.",
                examplePastTranslation = "La economía se desaceleró el último trimestre.",
                highlightSpanishPast = "se desaceleró",
                exampleCommon = "You need to slow down and rest.",
                exampleCommonTranslation = "Tú necesitas ir más despacio y descansar.",
                highlightSpanishCommon = "ir más despacio"
            ),

            PhrasalVerb(
                verb = "speak up",
                translation = "hablar más fuerte / expresarse",
                usageContext = "Se usa para:\n• Pedir a alguien que hable más alto\n• Expresar una opinión con valentía",
                examplePresent = "Teachers ask quiet students to speak up.",
                examplePresentTranslation = "Los profesores piden a los estudiantes callados que hablen más fuerte.",
                highlightSpanishPresent = "hablen más fuerte",
                examplePast = "He spoke up about the injustice he saw.",
                examplePastTranslation = "Él se expresó sobre la injusticia que vio.",
                highlightSpanishPast = "se expresó",
                exampleCommon = "She has spoken up for her rights.",
                exampleCommonTranslation = "Ella se ha expresado por sus derechos.",
                highlightSpanishCommon = "se ha expresado"
            ),

            PhrasalVerb(
                verb = "stand up",
                translation = "ponerse de pie / defender",
                usageContext = "Se usa para:\n• Levantarse de una posición sentada\n• Defender a alguien o algo\n• Mantenerse firme",
                examplePresent = "Audiences stand up for the national anthem.",
                examplePresentTranslation = "Las audiencias se ponen de pie para el himno nacional.",
                highlightSpanishPresent = "se ponen de pie",
                examplePast = "He stood up for his friend during the argument.",
                examplePastTranslation = "Él defendió a su amigo durante la discusión.",
                highlightSpanishPast = "defendió",
                exampleCommon = "We have stood up against injustice.",
                exampleCommonTranslation = "Nosotros nos hemos puesto de pie contra la injusticia.",
                highlightSpanishCommon = "nos hemos puesto"
            ),

            PhrasalVerb(
                verb = "take after",
                translation = "parecerse a (familiar)",
                usageContext = "Se usa para describir similitudes físicas o de personalidad con familiares.",
                examplePresent = "Children often take after their parents.",
                examplePresentTranslation = "Los niños a menudo se parecen a sus padres.",
                highlightSpanishPresent = "se parecen",
                examplePast = "She took after her grandmother in many ways.",
                examplePastTranslation = "Ella se pareció a su abuela en muchas formas.",
                highlightSpanishPast = "se pareció",
                exampleCommon = "He has taken after his father's side of the family.",
                exampleCommonTranslation = "Él se ha parecido al lado de la familia de su padre.",
                highlightSpanishCommon = "se ha parecido"
            ),

            PhrasalVerb(
                verb = "take off",
                translation = "despegar (avión) / quitarse",
                usageContext = "Se usa para:\n• Aviones que despegan\n• Quitarse ropa o accesorios\n• Tener éxito rápidamente",
                examplePresent = "Planes take off from the runway smoothly.",
                examplePresentTranslation = "Los aviones despegan de la pista suavemente.",
                highlightSpanishPresent = "despegan",
                examplePast = "He took off his jacket when he entered.",
                examplePastTranslation = "Él se quitó su chaqueta cuando entró.",
                highlightSpanishPast = "se quitó",
                exampleCommon = "Her career has taken off recently.",
                exampleCommonTranslation = "Su carrera ha despegado recientemente.",
                highlightSpanishCommon = "ha despegado"
            ),

            PhrasalVerb(
                verb = "take on",
                translation = "asumir / aceptar",
                usageContext = "Se usa para aceptar responsabilidades, trabajos o desafíos.",
                examplePresent = "Leaders take on great responsibilities.",
                examplePresentTranslation = "Los líderes asumen grandes responsabilidades.",
                highlightSpanishPresent = "asumen",
                examplePast = "She took on a new project at work.",
                examplePastTranslation = "Ella asumió un nuevo proyecto en el trabajo.",
                highlightSpanishPast = "asumió",
                exampleCommon = "He has taken on too many commitments.",
                exampleCommonTranslation = "Él ha aceptado demasiados compromisos.",
                highlightSpanishCommon = "ha aceptado"
            ),

            PhrasalVerb(
                verb = "take over",
                translation = "tomar el control / hacerse cargo",
                usageContext = "Se usa para asumir el control de algo que otra persona hacía.",
                examplePresent = "New managers take over departments regularly.",
                examplePresentTranslation = "Los nuevos gerentes toman el control de departamentos regularmente.",
                highlightSpanishPresent = "toman el control",
                examplePast = "The army took over the government.",
                examplePastTranslation = "El ejército tomó el control del gobierno.",
                highlightSpanishPast = "tomó el control",
                exampleCommon = "She has taken over her father's business.",
                exampleCommonTranslation = "Ella se ha hecho cargo del negocio de su padre.",
                highlightSpanishCommon = "se ha hecho cargo"
            ),

            PhrasalVerb(
                verb = "take up",
                translation = "comenzar (hobby) / ocupar",
                usageContext = "Se usa para:\n• Empezar un nuevo hobby o actividad\n• Ocupar espacio o tiempo",
                examplePresent = "Many people take up exercise in January.",
                examplePresentTranslation = "Muchas personas comienzan ejercicio en enero.",
                highlightSpanishPresent = "comienzan",
                examplePast = "He took up painting after retirement.",
                examplePastTranslation = "Él comenzó a pintar después de jubilarse.",
                highlightSpanishPast = "comenzó",
                exampleCommon = "This furniture has taken up too much space.",
                exampleCommonTranslation = "Este mueble ha ocupado demasiado espacio.",
                highlightSpanishCommon = "ha ocupado"
            ),

            PhrasalVerb(
                verb = "talk over",
                translation = "discutir / conversar",
                usageContext = "Se usa para discutir algo detalladamente con alguien.",
                examplePresent = "Couples talk over their problems together.",
                examplePresentTranslation = "Las parejas discuten sus problemas juntas.",
                highlightSpanishPresent = "discuten",
                examplePast = "We talked over the proposal yesterday.",
                examplePastTranslation = "Nosotros discutimos la propuesta ayer.",
                highlightSpanishPast = "discutimos",
                exampleCommon = "They have talked over all the details.",
                exampleCommonTranslation = "Ellos han conversado todos los detalles.",
                highlightSpanishCommon = "han conversado"
            ),

            PhrasalVerb(
                verb = "tell off",
                translation = "regañar / reprender",
                usageContext = "Se usa para regañar a alguien por su comportamiento.",
                examplePresent = "Parents sometimes tell off their children.",
                examplePresentTranslation = "Los padres a veces regañan a sus hijos.",
                highlightSpanishPresent = "regañan",
                examplePast = "The teacher told off the noisy students.",
                examplePastTranslation = "El profesor regañó a los estudiantes ruidosos.",
                highlightSpanishPast = "regañó",
                exampleCommon = "He has been told off for being late.",
                exampleCommonTranslation = "Él ha sido regañado por llegar tarde.",
                highlightSpanishCommon = "ha sido regañado"
            ),

            PhrasalVerb(
                verb = "think over",
                translation = "pensar detenidamente / considerar",
                usageContext = "Se usa para considerar algo cuidadosamente antes de decidir.",
                examplePresent = "I think over important decisions carefully.",
                examplePresentTranslation = "Yo pienso detenidamente decisiones importantes.",
                highlightSpanishPresent = "pienso",
                examplePast = "She thought over the job offer for a week.",
                examplePastTranslation = "Ella consideró la oferta de trabajo por una semana.",
                highlightSpanishPast = "consideró",
                exampleCommon = "We have thought over all the possibilities.",
                exampleCommonTranslation = "Nosotros hemos considerado todas las posibilidades.",
                highlightSpanishCommon = "hemos considerado"
            ),

            PhrasalVerb(
                verb = "throw away",
                translation = "tirar (a la basura)",
                usageContext = "Se usa para deshacerse de algo poniéndolo en la basura.",
                examplePresent = "People throw away too much plastic.",
                examplePresentTranslation = "Las personas tiran demasiado plástico.",
                highlightSpanishPresent = "tiran",
                examplePast = "I threw away old magazines yesterday.",
                examplePastTranslation = "Yo tiré revistas viejas ayer.",
                highlightSpanishPast = "tiré",
                exampleCommon = "She has thrown away all the expired food.",
                exampleCommonTranslation = "Ella ha tirado toda la comida vencida.",
                highlightSpanishCommon = "ha tirado"
            ),

            PhrasalVerb(
                verb = "try on",
                translation = "probarse (ropa)",
                usageContext = "Se usa específicamente para probarse ropa antes de comprarla.",
                examplePresent = "Shoppers try on clothes in fitting rooms.",
                examplePresentTranslation = "Los compradores se prueban ropa en los probadores.",
                highlightSpanishPresent = "se prueban",
                examplePast = "She tried on three dresses before choosing one.",
                examplePastTranslation = "Ella se probó tres vestidos antes de elegir uno.",
                highlightSpanishPast = "se probó",
                exampleCommon = "I have tried on these shoes several times.",
                exampleCommonTranslation = "Yo me he probado estos zapatos varias veces.",
                highlightSpanishCommon = "me he probado"
            ),

            PhrasalVerb(
                verb = "try out",
                translation = "probar / probar (para equipo)",
                usageContext = "Se usa para:\n• Probar algo para ver si funciona o gusta\n• Intentar ingresar a un equipo deportivo",
                examplePresent = "People try out new recipes on weekends.",
                examplePresentTranslation = "Las personas prueban nuevas recetas los fines de semana.",
                highlightSpanishPresent = "prueban",
                examplePast = "He tried out for the basketball team.",
                examplePastTranslation = "Él probó para el equipo de baloncesto.",
                highlightSpanishPast = "probó",
                exampleCommon = "We have tried out several different approaches.",
                exampleCommonTranslation = "Nosotros hemos probado varios enfoques diferentes.",
                highlightSpanishCommon = "hemos probado"
            ),

            PhrasalVerb(
                verb = "turn down",
                translation = "rechazar / bajar volumen",
                usageContext = "Se usa para:\n• Rechazar una oferta o invitación\n• Reducir el volumen o intensidad",
                examplePresent = "Some people turn down job offers for various reasons.",
                examplePresentTranslation = "Algunas personas rechazan ofertas de trabajo por varias razones.",
                highlightSpanishPresent = "rechazan",
                examplePast = "She turned down the marriage proposal.",
                examplePastTranslation = "Ella rechazó la propuesta de matrimonio.",
                highlightSpanishPast = "rechazó",
                exampleCommon = "He has turned down the music.",
                exampleCommonTranslation = "Él ha bajado la música.",
                highlightSpanishCommon = "ha bajado"
            ),

            PhrasalVerb(
                verb = "turn off",
                translation = "apagar",
                usageContext = "Se usa para:\n• Apagar luces o dispositivos\n• Perder interés en algo",
                examplePresent = "We turn off lights to save energy.",
                examplePresentTranslation = "Nosotros apagamos luces para ahorrar energía.",
                highlightSpanishPresent = "apagamos",
                examplePast = "He turned off the TV and went to bed.",
                examplePastTranslation = "Él apagó la TV y se fue a la cama.",
                highlightSpanishPast = "apagó",
                exampleCommon = "The bad behavior has turned off many customers.",
                exampleCommonTranslation = "El mal comportamiento ha alejado a muchos clientes.",
                highlightSpanishCommon = "ha alejado"
            ),

            PhrasalVerb(
                verb = "turn on",
                translation = "encender",
                usageContext = "Se usa para:\n• Encender luces o dispositivos\n• Atacar verbal o físicamente\n• Interesar o excitar",
                examplePresent = "I turn on the computer first thing in the morning.",
                examplePresentTranslation = "Yo enciendo la computadora lo primero en la mañana.",
                highlightSpanishPresent = "enciendo",
                examplePast = "She turned on the heater because it was cold.",
                examplePastTranslation = "Ella encendió el calentador porque hacía frío.",
                highlightSpanishPast = "encendió",
                exampleCommon = "This music has turned on a new generation.",
                exampleCommonTranslation = "Esta música ha encendido a una nueva generación.",
                highlightSpanishCommon = "ha encendido"
            ),

            PhrasalVerb(
                verb = "turn up",
                translation = "aparecer / subir volumen",
                usageContext = "Se usa para:\n• Llegar o aparecer (especialmente inesperadamente)\n• Aumentar el volumen o intensidad\n• Ser encontrado después de estar perdido",
                examplePresent = "Some guests turn up without invitation.",
                examplePresentTranslation = "Algunos invitados aparecen sin invitación.",
                highlightSpanishPresent = "aparecen",
                examplePast = "He turned up at the party unexpectedly.",
                examplePastTranslation = "Él apareció en la fiesta inesperadamente.",
                highlightSpanishPast = "apareció",
                exampleCommon = "The missing documents have turned up.",
                exampleCommonTranslation = "Los documentos perdidos han aparecido.",
                highlightSpanishCommon = "han aparecido"
            ),

            PhrasalVerb(
                verb = "use up",
                translation = "agotar / consumir completamente",
                usageContext = "Se usa para consumir todo lo disponible de algo.",
                examplePresent = "Factories use up natural resources quickly.",
                examplePresentTranslation = "Las fábricas agotan recursos naturales rápidamente.",
                highlightSpanishPresent = "agotan",
                examplePast = "We used up all the milk at breakfast.",
                examplePastTranslation = "Nosotros consumimos toda la leche en el desayuno.",
                highlightSpanishPast = "consumimos",
                exampleCommon = "She has used up all her vacation days.",
                exampleCommonTranslation = "Ella ha agotado todos sus días de vacaciones.",
                highlightSpanishCommon = "ha agotado"
            ),

            PhrasalVerb(
                verb = "wake up",
                translation = "despertarse",
                usageContext = "Se usa para dejar de dormir y volver a la consciencia.",
                examplePresent = "I wake up at 6:30 every morning.",
                examplePresentTranslation = "Yo me despierto a las 6:30 cada mañana.",
                highlightSpanishPresent = "despierto",
                examplePast = "She woke up suddenly in the middle of the night.",
                examplePastTranslation = "Ella se despertó repentinamente en medio de la noche.",
                highlightSpanishPast = "despertó",
                exampleCommon = "We have woken up early all week.",
                exampleCommonTranslation = "Nosotros nos hemos despertado temprano toda la semana.",
                highlightSpanishCommon = "despertado"
            ),

            PhrasalVerb(
                verb = "warm up",
                translation = "calentar / calentarse",
                usageContext = "Se usa para:\n• Preparar el cuerpo para ejercicio\n• Aumentar la temperatura\n• Hacer que algo se ponga más cálido",
                examplePresent = "Athletes warm up before competitions.",
                examplePresentTranslation = "Los atletas se calientan antes de las competencias.",
                highlightSpanishPresent = "se calientan",
                examplePast = "The room warmed up after we turned on the heater.",
                examplePastTranslation = "La habitación se calentó después de que encendimos el calentador.",
                highlightSpanishPast = "se calentó",
                exampleCommon = "I have warmed up some soup for dinner.",
                exampleCommonTranslation = "Yo he calentado algo de sopa para la cena.",
                highlightSpanishCommon = "he calentado"
            ),

            PhrasalVerb(
                verb = "wash up",
                translation = "lavar (platos) / lavarse",
                usageContext = "Se usa para:\n• Lavar platos después de comer\n• Lavarse las manos o la cara",
                examplePresent = "I wash up after every meal.",
                examplePresentTranslation = "Yo lavo los platos después de cada comida.",
                highlightSpanishPresent = "lavo",
                examplePast = "He washed up before dinner.",
                examplePastTranslation = "Él se lavó antes de cenar.",
                highlightSpanishPast = "se lavó",
                exampleCommon = "We have washed up all the dishes.",
                exampleCommonTranslation = "Nosotros hemos lavado todos los platos.",
                highlightSpanishCommon = "hemos lavado"
            ),

            PhrasalVerb(
                verb = "watch out",
                translation = "¡cuidado! / estar alerta",
                usageContext = "Se usa para advertir de peligro o pedir que se esté atento.",
                examplePresent = "Watch out! There's a hole in the sidewalk.",
                examplePresentTranslation = "¡Cuidado! Hay un hoyo en la acera.",
                highlightSpanishPresent = "Cuidado",
                examplePast = "She watched out for her little brother.",
                examplePastTranslation = "Ella estuvo alerta a su hermanito.",
                highlightSpanishPast = "estuvo alerta",
                exampleCommon = "We have watched out for each other always.",
                exampleCommonTranslation = "Nosotros nos hemos cuidado mutuamente siempre.",
                highlightSpanishCommon = "nos hemos cuidado"
            ),

            PhrasalVerb(
                verb = "wear out",
                translation = "gastar / cansar",
                usageContext = "Se usa para:\n• Gastar algo con el uso\n• Cansar física o mentalmente a alguien",
                examplePresent = "Children wear out shoes quickly.",
                examplePresentTranslation = "Los niños gastan zapatos rápidamente.",
                highlightSpanishPresent = "gastan",
                examplePast = "The long journey wore out the travelers.",
                examplePastTranslation = "El largo viaje cansó a los viajeros.",
                highlightSpanishPast = "cansó",
                exampleCommon = "These shoes have worn out completely.",
                exampleCommonTranslation = "Estos zapatos se han gastado completamente.",
                highlightSpanishCommon = "se han gastado"
            ),

            PhrasalVerb(
                verb = "work out",
                translation = "hacer ejercicio / resolver",
                usageContext = "Se usa para:\n• Hacer ejercicio físico\n• Resolver un problema\n• Salir bien o tener éxito",
                examplePresent = "Many people work out at the gym.",
                examplePresentTranslation = "Muchas personas hacen ejercicio en el gimnasio.",
                highlightSpanishPresent = "hacen ejercicio",
                examplePast = "They worked out a solution together.",
                examplePastTranslation = "Ellos resolvieron una solución juntos.",
                highlightSpanishPast = "resolvieron",
                exampleCommon = "Everything has worked out perfectly.",
                exampleCommonTranslation = "Todo ha salido perfectamente.",
                highlightSpanishCommon = "ha salido"
            ),

            PhrasalVerb(
                verb = "write down",
                translation = "anotar / escribir",
                usageContext = "Se usa para registrar información por escrito.",
                examplePresent = "Students write down important notes in class.",
                examplePresentTranslation = "Los estudiantes anotan apuntes importantes en clase.",
                highlightSpanishPresent = "anotan",
                examplePast = "I wrote down the phone number.",
                examplePastTranslation = "Yo anoté el número de teléfono.",
                highlightSpanishPast = "anoté",
                exampleCommon = "She has written down all the instructions.",
                exampleCommonTranslation = "Ella ha escrito todas las instrucciones.",
                highlightSpanishCommon = "ha escrito"
            ),

            PhrasalVerb(
                verb = "write up",
                translation = "redactar / escribir formalmente",
                usageContext = "Se usa para preparar un documento o reporte formal por escrito.",
                examplePresent = "Journalists write up news articles daily.",
                examplePresentTranslation = "Los periodistas redactan artículos de noticias diariamente.",
                highlightSpanishPresent = "redactan",
                examplePast = "He wrote up a detailed report of the incident.",
                examplePastTranslation = "Él redactó un reporte detallado del incidente.",
                highlightSpanishPast = "redactó",
                exampleCommon = "I have written up the meeting minutes.",
                exampleCommonTranslation = "Yo he redactado las minutas de la reunión.",
                highlightSpanishCommon = "he redactado"
            )
    ).sortedBy { it.verb }

    override fun getPhrasalVerbs(): List<PhrasalVerb> = phrasalVerbs
}
