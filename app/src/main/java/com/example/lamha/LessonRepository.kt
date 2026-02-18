package com.example.lamha

object LessonRepository {
    fun getLessons(): List<Lesson> {
        return listOf(
            Lesson(
                id = "day_1",
                dayTitle = "Day 1",
                street = StreetSection(
                    title = "Negotiating an Auto",
                    dialogue = listOf(
                        DialogueLine("d1_s_1", "Passenger", "भैया, कनॉट प्लेस चलेंगे?", "Bhaiya, will you go to Connaught Place?"),
                        DialogueLine("d1_s_2", "Auto Driver", "हाँ जी, बैठिए। कहाँ जाना है—ठीक-ठीक बता दीजिए।", "Yes—please sit. Tell me clearly where you want to go."),
                        DialogueLine("d1_s_3", "Passenger", "इनर सर्कल जाना है। मीटर से चलेंगे?", "I need to go to the Inner Circle. Will you go by meter?"),
                        DialogueLine("d1_s_4", "Auto Driver", "मीटर नहीं होगा, भैया। २०० रुपये फिक्स।", "No meter, bhaiya. 200 rupees fixed."),
                        DialogueLine("d1_s_5", "Passenger", "अरे, ये तो बहुत ज़्यादा है। १५० कर लीजिए।", "That’s too much. Make it 150."),
                        DialogueLine("d1_s_6", "Auto Driver", "आगे ट्रैफ़िक बहुत है, टाइम लगेगा। १८० दे दीजिए।", "There’s a lot of traffic ahead, it’ll take time. Please give 180."),
                        DialogueLine("d1_s_7", "Passenger", "ठीक है, चलिए। बस ट्रैफ़िक वाली साइड से मत ले जाना।", "Okay, let’s go. Just don’t take me through the traffic side."),
                        DialogueLine("d1_s_8", "Auto Driver", "चिंता मत कीजिए—शॉर्टकट से ले चलता हूँ।", "Don’t worry—I’ll take you via a shortcut.")
                    ),
                    vocabulary = listOf(
                        VocabItem(
                            "d1_v_1",
                            "चलना (chalnā)",
                            "to go / to move",
                            "Verb. In real speech you’ll hear: ‘चलेंगे?’ (polite) / ‘चलोगे?’ (casual). Used when asking someone to go/drive somewhere."
                        ),
                        VocabItem(
                            "d1_v_2",
                            "भैया (bhaiyā)",
                            "bhaiya / brother (polite address)",
                            "Common North-Indian address for a male stranger (auto drivers, shopkeepers). Friendly + polite, not literal family."
                        ),
                        VocabItem(
                            "d1_v_3",
                            "बैठिए (baiṭhiye)",
                            "please sit",
                            "Polite imperative (Aap-form). Pattern: verb stem + -इए (जाइए, बताइए, दीजिए)."
                        ),
                        VocabItem(
                            "d1_v_4",
                            "ठीक-ठीक (ṭhīk-ṭhīk)",
                            "clearly / exactly",
                            "Colloquial emphasis. Similar to ‘ठीक से’, but more everyday in speech: ‘ठीक-ठीक बता दीजिए’."
                        ),
                        VocabItem(
                            "d1_v_5",
                            "मीटर (mīṭar)",
                            "meter",
                            "Loanword. In auto/taxi talk: ‘मीटर से चलेंगे?’ = will you go by meter (not fixed price)."
                        ),
                        VocabItem(
                            "d1_v_6",
                            "ज़्यादा (zyādā)",
                            "too much / more",
                            "Very common everyday adjective (Urdu/Persian origin). In bargaining: ‘बहुत ज़्यादा है’."
                        ),
                        VocabItem(
                            "d1_v_7",
                            "फिक्स (fixed)",
                            "fixed (price)",
                            "Hinglish. ‘२०० फिक्स’ means the price is non-meter, set in advance."
                        ),
                        VocabItem(
                            "d1_v_8",
                            "ट्रैफ़िक (traffic)",
                            "traffic",
                            "Everyday Hinglish. Often paired with ‘टाइम लगेगा’ (it will take time)."
                        ),
                        VocabItem(
                            "d1_v_9",
                            "शॉर्टकट (shortcut)",
                            "shortcut",
                            "Common spoken word for a faster route. You’ll also hear ‘छोटा रास्ता’."
                        ),
                        VocabItem(
                            "d1_v_10",
                            "चिंता (chintā)",
                            "worry / concern",
                            "‘चिंता मत कीजिए’ is a very standard polite reassurance (aap-form)."
                        )
                    ),
                    grammarGuides = listOf(
                        GrammarPoint(
                            "Politeness & Register (Aap vs Tum)",
                            "Hindi has different levels of ‘you’. In daily city speech, you’ll often keep things polite with **Aap + जी** with strangers (coworker-level politeness).\n\nExamples from this lesson:\n- **चलेंगे? / दीजिए / बैठिए** → Aap-form (polite)\n- **चलोगे? / दे दो / बैठो** → Tum-form (more casual)\n\nRule of thumb (beginner-friendly): start with **Aap** in real life; you can switch to Tum only when the vibe is clearly informal."
                        ),
                        GrammarPoint(
                            "Useful polite patterns for bargaining",
                            "These patterns sound natural without being slangy:\n\n1) **X कर लीजिए** = ‘Please make it X’ (soft negotiation)\n- ‘१५० कर लीजिए।’\n\n2) **X दे दीजिए** = ‘Please give X’ (polite request)\n- ‘१८० दे दीजिए।’\n\n3) **मत + (verb)** = ‘Don’t…’ (polite/casual depends on ending)\n- ‘मत ले जाना’ (request not to take a route)\n- more polite: ‘मत ले जाइए’"
                        ),
                        GrammarPoint(
                            "Postposition ‘से’ (se) in travel talk",
                            "‘से’ marks **means / route / instrument**:\n- **मीटर से** = by meter (using the meter as the pricing method)\n- **शॉर्टकट से** = via a shortcut (using a shortcut route)\n\nIt links the noun to the action: ‘मीटर से चलेंगे?’ (Will you go by meter?)"
                        )
                    )
                ),
                court = CourtSection(
                    title = "The Grief of Amir Khusrau",
                    poemLines = listOf(
                        "गोरी सोवे सेज पर, मुख पर डारे केस।",
                        "चल खुसरो घर आपने, साँझ भई चहुँ देस॥",
                        "Gori sove sej par, mukh par ḍāre kes",
                        "Chal Khusrau ghar āpne, sāñjh bhaī chahuñ des"
                    ),
                    analysis = "This legendary doha (couplet) was uttered by Amir Khusrau immediately upon seeing the face of his deceased spiritual master, Nizamuddin Auliya. It is a masterpiece of Sufi ambiguity.\n\n**The Sufi Context (Urs):** In Sufism, death is not a tragedy but a 'Wedding' (Urs)—the soul's reunion with the Divine. Khusrau sees his master not as a corpse, but as a 'Gori' (fair maiden/bride) finally resting on the 'Sej' (bridal bed) after the long struggle of life, her face covered in the veil of mystery (Kes).\n\n**The Human Grief:** Simultaneously, the second line shifts to Khusrau's personal despair. 'Saanjh bhaī' (Evening has fallen) signifies the setting of the sun on his own life. With his guide gone, the world ('Chahu des') has plunged into darkness.",
                    wordBreakdown = listOf(
                        WordAnalysis("d1_c_1", "गोरी (Gori)", "Fair maiden", "The Soul (of the Saint), pure and ready for union."),
                        WordAnalysis("d1_c_2", "सोवे (Sove)", "Sleeps", "Death / Eternal Rest / The state of Union."),
                        WordAnalysis("d1_c_3", "सेज (Sej)", "Bed (bridal)", "The bier / Grave / The place of final union."),
                        WordAnalysis("d1_c_4", "मुख (Mukh)", "Face", "Identity / Earthly presence."),
                        WordAnalysis("d1_c_5", "केस (Kes)", "Hair", "Veil / Darkness / The mystery of death."),
                        WordAnalysis("d1_c_6", "घर आपने (Ghar Aapne)", "To [my] own house", "The true home (The Divine/Afterlife)."),
                        WordAnalysis("d1_c_7", "साँझ (Saanjh)", "Evening", "The end of life / The onset of spiritual darkness."),
                        WordAnalysis("d1_c_8", "चहुँ देस (Chahuñ Des)", "All 4 directions", "The entire physical world (now empty).")
                    )
                )
            ),
            Lesson(
                id = "day_2",
                dayTitle = "Day 2",
                street = StreetSection(
                    title = "Asking for Directions",
                    dialogue = listOf(
                        DialogueLine("d2_s_1", "Tourist", "Excuse me ji—लाल किला किधर है?", "Excuse me—where is the Red Fort?"),
                        DialogueLine("d2_s_2", "Local", "आप सीधे जाइए, फिर बाएँ मुड़ जाइए।", "Go straight, then turn left."),
                        DialogueLine("d2_s_3", "Tourist", "क्या ये यहाँ से ज़्यादा दूर है?", "Is it far from here?"),
                        DialogueLine("d2_s_4", "Local", "नहीं, ज़्यादा दूर नहीं—बस दस मिनट का रास्ता है।", "No, not too far—about a 10-minute walk."),
                        DialogueLine("d2_s_5", "Tourist", "क्या मैं पैदल ही चला जाऊँ?", "Can I just walk?"),
                        DialogueLine("d2_s_6", "Local", "हाँ जी, आराम से। मौसम भी अच्छा है।", "Yes, easily. The weather is nice too."),
                        DialogueLine("d2_s_7", "Tourist", "शुक्रिया जी।", "Thank you."),
                        DialogueLine("d2_s_8", "Local", "कोई बात नहीं जी।", "No worries.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d2_v_1", "माफ़ कीजिये (māf kījiye)", "Excuse me / sorry", "Polite opener. In daily speech you can also say: ‘Excuse me ji…’ when asking strangers."),
                        VocabItem("d2_v_2", "कहाँ / किधर (kahaan / kidhar)", "where", "‘कहाँ’ is standard; ‘किधर’ is very common spoken Hindi (Delhi/North)."),
                        VocabItem("d2_v_3", "सीधे (sīdhe)", "straight", "Direction word: ‘सीधे जाइए’ = go straight."),
                        VocabItem("d2_v_4", "बाएँ (baaẽ)", "left", "Direction. Spoken Hindi often uses English too: left/right."),
                        VocabItem("d2_v_5", "मुड़ना / मुड़ जाइए (muRna / muR jaaiye)", "to turn", "Polite direction: ‘बाएँ मुड़ जाइए’ = please turn left."),
                        VocabItem("d2_v_6", "दूर (door)", "far", "Distance: ‘ज़्यादा दूर’ = too far; ‘कितनी दूर?’ = how far?"),
                        VocabItem("d2_v_7", "पैदल (paidal)", "on foot", "‘पैदल ही’ = just on foot. ‘पैदल चला जाऊँ?’ is natural."),
                        VocabItem("d2_v_8", "मौसम (mausam)", "weather", "Everyday noun. ‘मौसम अच्छा है’ = the weather is nice.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Everyday question patterns (beginner-friendly)", "Keep questions short and polite:\n\n1) **X कहाँ/किधर है?** = Where is X?\n- ‘लाल किला किधर है?’\n\n2) **क्या … ?** = Yes/No question\n- ‘क्या ये दूर है?’\n\nTip: add **जी** to sound polite: ‘किधर है जी?’"),
                        GrammarPoint("Giving directions politely (Aap-form)", "Polite direction verbs you will hear a lot:\n- **जाइए** = please go\n- **मुड़ जाइए** = please turn\n\nCommon frame:\n- ‘आप सीधे जाइए, फिर बाएँ मुड़ जाइए।’\n\nMistake to avoid: using only ‘left…’ without a verb. Better: ‘left ले लीजिए’ / ‘बाएँ मुड़ जाइए’."),
                        GrammarPoint("Time-distance phrase: ‘X minute ka raasta’", "A very common spoken pattern:\n\n- **दस मिनट का रास्ता** = about a 10-minute way\n\nGrammar note: **का/की/के** agrees with the noun:\n- ‘रास्ता’ (m) → ‘का’\n- ‘दूरी’ (f) → ‘की’\n\nExample: ‘यहाँ से बस दस मिनट का रास्ता है।’")
                    )
                ),
                court = CourtSection(
                    title = "Kabir's Truth",
                    poemLines = listOf(
                        "पोथी पढ़ि पढ़ि जग मुआ, पंडित भया न कोय।",
                        "ढाई आखर प्रेम का, पढ़े सो पंडित होय॥",
                        "Pothi paḍhi paḍhi jag muā, pandit bhayā na koy",
                        "Ḍhāī ākhar prem kā, paḍhe so pandit hoy"
                    ),
                    analysis = "Kabir Das, the great weaver-poet, challenges the orthodoxy of bookish knowledge. He asserts that true wisdom comes not from scriptures but from love.\n\n**The Critique:** 'Pothi' refers to heavy religious scriptures. Kabir says the world has died (wasted its life) reading them, yet no one became truly wise ('Pandit').\n\n**The Solution:** The 'Two and a half letters' (Dhai Akhar) refer to the word 'Prem' (Love) - which in Hindi script is arguably composed of two and a half strokes/sounds. Understanding love makes one a true knower.",
                    wordBreakdown = listOf(
                        WordAnalysis("d2_c_1", "पोथी (Pothi)", "Book/Scripture", "Symbol of rigid, theoretical knowledge."),
                        WordAnalysis("d2_c_2", "मुआ (Mua)", "Died", "Metaphor for wasted effort/spiritual death."),
                        WordAnalysis("d2_c_3", "पंडित (Pandit)", "Scholar/Wise man", "The goal of intellectual pursuit."),
                        WordAnalysis("d2_c_4", "भया (Bhaya)", "Became", "State of being."),
                        WordAnalysis("d2_c_5", "ढाई (Dhai)", "Two and a half", "Refers to the brevity/simplicity of Truth vs complex texts."),
                        WordAnalysis("d2_c_6", "आखर (Akhar)", "Letter/Alphabet", "The building block of words."),
                        WordAnalysis("d2_c_7", "प्रेम (Prem)", "Love", "Divine love/Bhakti."),
                        WordAnalysis("d2_c_8", "होय (Hoy)", "Becomes", "Transformation.")
                    )
                )
            ),
            Lesson(
                id = "day_3",
                dayTitle = "Day 3",
                street = StreetSection(
                    title = "Ordering Food",
                    dialogue = listOf(
                        DialogueLine("d3_s_1", "Server", "नमस्ते सर। क्या लाऊँ?", "Hello sir—what can I get you?"),
                        DialogueLine("d3_s_2", "Customer", "मेनू दे दीजिए। आज क्या अच्छा है?", "Please give me the menu. What’s good today?"),
                        DialogueLine("d3_s_3", "Server", "आज दाल मखनी और पनीर बटर मसाला बढ़िया है।", "Today the dal makhani and paneer butter masala are really good."),
                        DialogueLine("d3_s_4", "Customer", "एक दाल मखनी और दो बटर नान दे दीजिए।", "One dal makhani and two butter naans, please."),
                        DialogueLine("d3_s_5", "Server", "मिर्च/मसाला कैसी रखूँ—ज़्यादा या कम?", "How spicy should I make it—more or less?"),
                        DialogueLine("d3_s_6", "Customer", "कम मिर्च रख दीजिए। और पानी की एक बोतल भी।", "Please keep it less spicy. And one water bottle too."),
                        DialogueLine("d3_s_7", "Server", "ठीक है सर—दस मिनट में आ जाएगा।", "Okay—it’ll be here in 10 minutes."),
                        DialogueLine("d3_s_8", "Customer", "थोड़ा जल्दी कर दीजिए, मुझे भूख लगी है।", "Please do it a bit quickly—I’m hungry.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d3_v_1", "लाऊँ (lāūñ)", "shall I bring? / can I get you?", "Service Hindi uses this a lot: ‘क्या लाऊँ?’ = What can I get you? (very natural at restaurants)."),
                        VocabItem("d3_v_2", "ताज़ा / अच्छा (taazaa / achchhaa)", "fresh / good", "In restaurants, people often ask ‘आज क्या अच्छा है?’ (What’s good today?) in addition to ‘ताज़ा’."),
                        VocabItem("d3_v_3", "दाल / दाल मखनी (daal / daal makhni)", "lentils / dal makhani", "Common dish name. Saying the full dish is more natural: ‘एक दाल मखनी…’."),
                        VocabItem("d3_v_4", "मिर्च / मसाला (mirch / masaalaa)", "chili / spice", "Both are used. ‘मसाला’ is broader for spice level."),
                        VocabItem("d3_v_5", "रखूँ (rakhūñ)", "should I keep/make it?", "‘कैसी रखूँ?’ = how should I make it/keep it (spice level). Natural service phrasing."),
                        VocabItem("d3_v_6", "भूख (bhookh)", "hunger", "Most natural sentence: ‘मुझे भूख लगी है।’ (lit. hunger has struck me)."),
                        VocabItem("d3_v_7", "जल्दी / थोड़ा जल्दी (jaldi / thodaa jaldi)", "quickly / a bit quickly", "To sound polite: ‘थोड़ा जल्दी कर दीजिए’ (Please do it a bit quickly)."),
                        VocabItem("d3_v_8", "आ जाएगा (aa jaayegaa)", "will arrive / will come", "Very common spoken future: ‘दस मिनट में आ जाएगा’।")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Service question: ‘क्या लाऊँ?’ (very common)", "In restaurants/stalls, staff often ask:\n\n- **क्या लाऊँ?** = What can I get you?\n- **क्या लेंगे?** = What will you have?\n\nThese are natural, polite, and beginner-friendly patterns."),
                        GrammarPoint("‘मुझे भूख लगी है’ (how Hindi expresses hunger)", "Hindi often expresses sensations as something happening to you:\n\n- **मुझे भूख लगी है।** = I’m hungry\n- **मुझे प्यास लगी है।** = I’m thirsty\n\nBeginner tip: memorize these as fixed phrases."),
                        GrammarPoint("Polite requests: ‘… कर दीजिए / … दे दीजिए’", "To keep a coworker-level polite tone, use:\n\n- **मेनू दे दीजिए।** (please give the menu)\n- **कम मिर्च रख दीजिए।** (please keep it less spicy)\n- **थोड़ा जल्दी कर दीजिए।** (please do it a bit quickly)\n\nThese sound natural and not textbook-stiff.")
                    )
                ),
                court = CourtSection(
                    title = "Ghalib's Wine & Love",
                    poemLines = listOf(
                        "हज़ारों ख़्वाहिशें ऐसी कि हर ख़्वाहिश पे दम निकले,",
                        "बहुत निकले मेरे अरमान लेकिन फिर भी कम निकले।",
                        "Hazāron khwāhishen aisī ki har khwāhish pe dam nikle",
                        "Bahut nikle mere armān lekin phir bhī kam nikle"
                    ),
                    analysis = "Mirza Ghalib encapsulates the insatiable nature of human desire. This sher (couplet) is one of the most quoted lines in Urdu/Hindi literature.\n\n**The Paradox:** He has 'thousands' of desires, each so intense that it could consume his life ('dam nikle' - breath leaves). Many desires were fulfilled ('nikle'), yet so many remain that it feels like too few were met.\n\n**Philosophical Note:** It highlights the tragic beauty of life—defined not by satisfaction, but by the relentless pursuit of longing.",
                    wordBreakdown = listOf(
                        WordAnalysis("d3_c_1", "हज़ारों (Hazāron)", "Thousands", "Plural of Hazar."),
                        WordAnalysis("d3_c_2", "ख़्वाहिशें (Khwāhishen)", "Desires/Wishes", "Urdu noun (F)."),
                        WordAnalysis("d3_c_3", "दम निकले (Dam nikle)", "Breath leaves", "To die / To spend a lifetime."),
                        WordAnalysis("d3_c_4", "अरमान (Armān)", "Longings/Yearnings", "Similar to Khwahish but deeper."),
                        WordAnalysis("d3_c_5", "फिर भी (Phir bhī)", "Even then/Still", "Conjunction."),
                        WordAnalysis("d3_c_6", "कम (Kam)", "Few/Less", "Adjective.")
                    )
                )
            ),
            Lesson(
                id = "day_4",
                dayTitle = "Day 4",
                street = StreetSection(
                    title = "Bargaining at the Market",
                    dialogue = listOf(
                        DialogueLine("d4_s_1", "Shopper", "ये कुर्ता कितने का है, भैया?", "How much is this kurta, bhaiya?"),
                        DialogueLine("d4_s_2", "Shopkeeper", "पूरा रेशम है जी—५,००० रुपये।", "It’s pure silk—5,000 rupees."),
                        DialogueLine("d4_s_3", "Shopper", "अरे, ये तो बहुत महँगा है। थोड़ा कम हो जाएगा क्या?", "Oh, that’s too expensive. Can you do a little less?"),
                        DialogueLine("d4_s_4", "Shopkeeper", "मैडम, क्वालिटी देखिए। चलिए, ४५०० कर देते हैं।", "Ma’am, look at the quality. Okay, I’ll make it 4,500."),
                        DialogueLine("d4_s_5", "Shopper", "ठीक है, लेकिन २५०० से ज़्यादा नहीं दूँगी।", "Okay, but I won’t pay more than 2,500."),
                        DialogueLine("d4_s_6", "Shopkeeper", "इतने में तो मुझे भी नहीं पड़ता! ३५०० लास्ट।", "Even I don’t get it for that much! 3,500 final."),
                        DialogueLine("d4_s_7", "Shopper", "३,००० कर लीजिए—वरना मैं जा रही हूँ।", "Make it 3,000—otherwise I’m leaving."),
                        DialogueLine("d4_s_8", "Shopkeeper", "अच्छा ठीक है, आपकी बात मान ली। पैक कर देता हूँ।", "Alright, fine—I’ll agree. I’ll pack it.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d4_v_1", "कुर्ता (kurtā)", "kurta", "Common clothing item. Often used exactly as ‘कुर्ता’."),
                        VocabItem("d4_v_2", "कितने का (kitne kaa)", "how much is it", "Price question pattern: ‘ये कितने का है?’ (lit. of how much)."),
                        VocabItem("d4_v_3", "महँगा (mahangā)", "expensive", "Opposite: सस्ता. In speech: ‘बहुत महँगा है’."),
                        VocabItem("d4_v_4", "दाम / रेट (daam / rate)", "price", "‘दाम’ is Hindi; ‘रेट’ is very common market Hinglish."),
                        VocabItem("d4_v_5", "कम हो जाएगा? (kam ho jaayegaa?)", "can it be less?", "Soft bargaining frame (polite): ‘थोड़ा कम हो जाएगा क्या?’"),
                        VocabItem("d4_v_6", "क्वालिटी (quality)", "quality", "Very common loanword used by sellers."),
                        VocabItem("d4_v_7", "लास्ट (last)", "final (price)", "Market speech for “final offer”: ‘३५०० लास्ट’."),
                        VocabItem("d4_v_8", "पैक करना (pack karnaa)", "to pack", "‘पैक कर देता हूँ’ = I’ll pack it (for you).")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Asking price: ‘ये कितने का है?’", "Most common way to ask price:\n\n- **ये कितने का है?** = How much is this?\n\nGrammar: **का/की/के** agrees with the item:\n- कुर्ता (m) → ‘कितने का’\n- साड़ी (f) → ‘कितनी की’\n\nExample: ‘ये कुर्ता कितने का है?’"),
                        GrammarPoint("Soft negotiation: ‘थोड़ा कम हो जाएगा?’ + ‘वरना…’", "Two useful patterns:\n\n1) **थोड़ा कम हो जाएगा क्या?** = Can you do a little less? (polite)\n2) **… वरना …** = otherwise\n- ‘३,००० कर लीजिए—वरना मैं जा रही हूँ।’\n\nBeginner tip: These sound natural without slang."),
                        GrammarPoint("Compound verbs for shop talk: ‘मान लेना / कर देना’", "Spoken Hindi uses helper verbs a lot:\n\n- **X कर देना** = set/do X (price)\n  - ‘४५०० कर देते हैं।’\n- **बात मान लेना** = agree\n  - ‘आपकी बात मान ली।’\n\nThese add a natural, everyday tone.")
                    )
                ),
                court = CourtSection(
                    title = "Mirabai's Devotion",
                    poemLines = listOf(
                        "मेरे तो गिरधर गोपाल, दूसरो न कोई।",
                        "जाके सिर मोर मुकुट, मेरो पति सोई॥",
                        "Mere to Girdhar Gopāl, dūsro na koī",
                        "Jāke sir mor mukuṭ, mero pati soī"
                    ),
                    analysis = "Mirabai, the Rajasthani princess turned mystic, declares her absolute, singular devotion to Krishna (Girdhar/Gopal). She rejects all worldly relations.\n\n**The Imagery:** She identifies her lord by the 'peacock feather crown' (Mor Mukut) on his head. She claims him as her 'husband' (Pati), defying the societal norms of her time which expected her to be a dutiful widow or wife to a mortal king.",
                    wordBreakdown = listOf(
                        WordAnalysis("d4_c_1", "गिरधर (Girdhar)", "One who holds the mountain", "Name of Krishna (Govardhan story)."),
                        WordAnalysis("d4_c_2", "गोपाल (Gopāl)", "Protector of cows", "Name of Krishna."),
                        WordAnalysis("d4_c_3", "दूसरो (Dūsro)", "Second/Other", "Another person."),
                        WordAnalysis("d4_c_4", "जाके (Jāke)", "On whose / Whose", "Braji/Rajasthani dialect for 'Jiske'."),
                        WordAnalysis("d4_c_5", "मोर (Mor)", "Peacock", "Symbol of Krishna."),
                        WordAnalysis("d4_c_6", "मुकुट (Mukuṭ)", "Crown", "Royal/Divine headgear."),
                        WordAnalysis("d4_c_7", "पति (Pati)", "Husband/Lord", "Master."),
                        WordAnalysis("d4_c_8", "सोई (Soī)", "He alone", "That very one.")
                    )
                )
            ),
            Lesson(
                id = "day_5",
                dayTitle = "Day 5",
                street = StreetSection(
                    title = "Introducing Family",
                    dialogue = listOf(
                        DialogueLine("d5_s_1", "Host", "आइए, मेरे परिवार से मिलिए।", "Come, please meet my family."),
                        DialogueLine("d5_s_2", "Guest", "ज़रूर। ये कौन हैं?", "Sure. Who is this?"),
                        DialogueLine("d5_s_3", "Host", "ये मेरे पिताजी हैं, और वो मेरी माँ हैं।", "This is my father, and that is my mother."),
                        DialogueLine("d5_s_4", "Guest", "नमस्ते अंकल, नमस्ते आंटी।", "Hello Uncle, hello Aunty."),
                        DialogueLine("d5_s_5", "Host", "और ये मेरा छोटा भाई है—राहुल।", "And this is my younger brother—Rahul."),
                        DialogueLine("d5_s_6", "Guest", "राहुल, आप क्या करते हैं?", "Rahul, what do you do?"),
                        DialogueLine("d5_s_7", "Rahul", "मैं कॉलेज में पढ़ता हूँ।", "I study in college."),
                        DialogueLine("d5_s_8", "Host", "हम सब साथ ही रहते हैं।", "We all live together.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d5_v_1", "परिवार (parivār)", "family", "Neutral word for family (formal + daily)."),
                        VocabItem("d5_v_2", "मिलिए (miliye)", "please meet", "Polite form used when introducing people: ‘परिवार से मिलिए’।"),
                        VocabItem("d5_v_3", "पिताजी (pitaaji)", "father (respectful)", "Respectful word. Daily alternatives: पापा/पापा जी."),
                        VocabItem("d5_v_4", "माँ (maã)", "mother", "Daily alternatives: मम्मी/मम्मी जी; ‘माँ’ is also common and neutral."),
                        VocabItem("d5_v_5", "छोटा (chhoṭā)", "younger / small", "Used for younger sibling: ‘छोटा भाई’. Opposite: बड़ा."),
                        VocabItem("d5_v_6", "भाई (bhaai)", "brother", "Can mean literal brother; also used as friendly address (‘भैया’)."),
                        VocabItem("d5_v_7", "पढ़ना (paRhnaa)", "to study/read", "‘मैं कॉलेज में पढ़ता हूँ’ = I study in college (habitual)."),
                        VocabItem("d5_v_8", "साथ (saath)", "together / with", "‘साथ रहना’ = to live together; ‘के साथ’ = with.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Introducing people: ‘ये… / वो…’", "To introduce people nearby vs farther:\n\n- **ये** = this / he/she (near)\n- **वो** = that / he/she (far)\n\nExample:\n- ‘ये मेरे पिताजी हैं, और वो मेरी माँ हैं।’\n\nBeginner tip: in conversation, ये/वो is often used even if distance isn’t literal."),
                        GrammarPoint("Respect markers: ‘जी’ + polite verb", "To sound coworker-level polite:\n\n- Add **जी**: ‘नमस्ते जी’, ‘धन्यवाद जी’\n- Use **आप** + polite verb endings: ‘आप क्या करते हैं?’\n\nThis keeps the tone respectful without sounding textbook-heavy."),
                        GrammarPoint("Present habitual (daily routine): ‘मैं … पढ़ता/पढ़ती हूँ’", "Habitual present describes routines/habits:\n\nPattern: **verb-stem + ता/ती/ते + हूँ/है/हैं**\n- ‘मैं पढ़ता हूँ।’ (m) / ‘मैं पढ़ती हूँ।’ (f)\n- ‘हम रहते हैं।’\n\nCommon mistake: using only infinitive ‘मैं पढ़ना’ (incorrect).")
                    )
                ),
                court = CourtSection(
                    title = "Premchand's Godaan",
                    poemLines = listOf(
                        "होरी ने कहा - 'जब दूसरे के पाँव",
                        "तले अपनी गर्दन दबी हो, तो उन",
                        "पाँवों को सहलाने में ही कुशल है।'",
                        "Hori ne kahā - 'Jab dūsre ke pāñv",
                        "tale apnī gardan dabī ho, to un",
                        "pāñvon ko sahlāne meñ hī kushal hai.'"
                    ),
                    analysis = "A prose excerpt from 'Godaan' (The Gift of a Cow), the greatest novel of Hindi literature by Munshi Premchand. Hori, the tragic peasant protagonist, explains his survival philosophy.\n\n**The Metaphor:** It is a stark look at feudal oppression. 'When your neck is under someone else's foot, it is wise to massage that foot.' It reflects the helplessness of the Indian farmer against the zamindar (landlord) and moneylenders.",
                    wordBreakdown = listOf(
                        WordAnalysis("d5_c_1", "पाँव (Pāñv)", "Foot/Feet", "Symbol of power/oppression."),
                        WordAnalysis("d5_c_2", "तले (Tale)", "Underneath", "Postposition."),
                        WordAnalysis("d5_c_3", "गर्दन (Gardan)", "Neck", "Symbol of life/dignity."),
                        WordAnalysis("d5_c_4", "दबी (Dabī)", "Pressed/Buried", "State of being trapped."),
                        WordAnalysis("d5_c_5", "सहलाने (Sahlāne)", "To massage/stroke", "Act of appeasement."),
                        WordAnalysis("d5_c_6", "कुशल (Kushal)", "Welfare/Wisdom", "Safety/Well-being.")
                    )
                )
            ),
            Lesson(
                id = "day_6",
                dayTitle = "Day 6",
                street = StreetSection(
                    title = "At the Pharmacy",
                    dialogue = listOf(
                        DialogueLine("d6_s_1", "Patient", "मुझे बुखार है और सर में दर्द है।", "I have a fever and a headache."),
                        DialogueLine("d6_s_2", "Chemist", "कब से है?", "Since when?"),
                        DialogueLine("d6_s_3", "Patient", "कल रात से। कृपया कोई दवा दे दीजिए।", "Since last night. Please give me some medicine."),
                        DialogueLine("d6_s_4", "Chemist", "ये लीजिए पैरासिटामोल। दिन में दो बार लीजिए।", "Here is paracetamol. Take it twice a day."),
                        DialogueLine("d6_s_5", "Patient", "क्या ये खाना खाने के बाद लेना है?", "Should I take it after food?"),
                        DialogueLine("d6_s_6", "Chemist", "हाँ, खाली पेट मत लीजिए।", "Yes, don’t take it on an empty stomach."),
                        DialogueLine("d6_s_7", "Patient", "गले में भी दर्द है।", "My throat hurts too."),
                        DialogueLine("d6_s_8", "Chemist", "तो ये कफ सिरप भी ले लीजिए।", "Then please take this cough syrup as well.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d6_v_1", "बुखार (bukhaar)", "fever", "Common illness word. Natural: ‘मुझे बुखार है’।"),
                        VocabItem("d6_v_2", "सरदर्द (sardard)", "headache", "Compound: सर (head) + दर्द (pain). Also said as ‘सर में दर्द’."),
                        VocabItem("d6_v_3", "कल (kal)", "yesterday / tomorrow", "Context decides. Here: ‘कल रात से’ = since last night."),
                        VocabItem("d6_v_4", "दवा (davaa)", "medicine", "General word for medicine (not a specific brand)."),
                        VocabItem("d6_v_5", "बार (baar)", "time(s)", "Frequency: ‘दिन में दो बार’ = twice a day."),
                        VocabItem("d6_v_6", "पेट (peT)", "stomach", "‘खाली पेट’ = empty stomach."),
                        VocabItem("d6_v_7", "खाली (khaali)", "empty", "Used in many contexts: empty stomach, empty room, etc."),
                        VocabItem("d6_v_8", "गला (galaa)", "throat", "‘गले में दर्द’ = throat pain.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Illness pattern: ‘मुझे ___ है’", "Common Hindi pattern for health states:\n\n- **मुझे बुखार है।** = I have a fever\n- **मुझे सर में दर्द है।** = I have a headache\n\nBeginner tip: don’t say ‘मैं बुखार हूँ’ (wrong)."),
                        GrammarPoint("Time starting point: ‘… से’", "‘से’ marks the starting point (since/from):\n\n- ‘कल रात से।’ = since last night\n- ‘सुबह से।’ = since morning\n\nVery common Q&A:\n- ‘कब से है?’ → ‘कल रात से।’"),
                        GrammarPoint("Don’t-do form: ‘मत + verb’ (polite vs casual)", "To say “don’t …”:\n\n- Casual: **मत लो**\n- Polite: **मत लीजिए**\n\nIn this lesson: ‘खाली पेट मत लीजिए।’ (Please don’t take it on an empty stomach).")
                    )
                ),
                court = CourtSection(
                    title = "Tulsidas' Ramcharitmanas",
                    poemLines = listOf(
                        "रघुकुल रीत सदा चली आई।",
                        "प्राण जाई पर बचन न जाई॥",
                        "Raghukul rīt sadā chalī āī",
                        "Prāṇ jāī par bachan na jāī"
                    ),
                    analysis = "From the Ramcharitmanas, describing the code of the Raghu clan (Rama's lineage). It defines the absolute integrity of the promised word.\n\n**The Code:** 'The tradition of Raghukul has always been: Life may go, but the Word (Promise) must not go.' King Dasharatha dies of grief but keeps his promise to exile Rama. This line is the bedrock of Indian ethos regarding 'Zuban' (Word of honor).",
                    wordBreakdown = listOf(
                        WordAnalysis("d6_c_1", "रघुकुल (Raghukul)", "Raghu Clan", "Lineage of Lord Rama."),
                        WordAnalysis("d6_c_2", "रीत (Rīt)", "Tradition/Custom", "Way of life."),
                        WordAnalysis("d6_c_3", "सदा (Sadā)", "Always", "Eternally."),
                        WordAnalysis("d6_c_4", "प्राण (Prāṇ)", "Life force/Breath", "Life itself."),
                        WordAnalysis("d6_c_5", "जाई (Jāī)", "Go/Leave", "Awadhi dialect form of 'Jaaye'."),
                        WordAnalysis("d6_c_6", "बचन (Bachan)", "Word/Promise", "Vachan.")
                    )
                )
            ),
            Lesson(
                id = "day_7",
                dayTitle = "Day 7",
                street = StreetSection(
                    title = "Travel by Train",
                    dialogue = listOf(
                        DialogueLine("d7_s_1", "Traveler", "मुंबई वाली ट्रेन किस प्लेटफॉर्म पर आएगी?", "Which platform will the Mumbai train come on?"),
                        DialogueLine("d7_s_2", "Official", "प्लेटफॉर्म नंबर चार पर।", "Platform number four."),
                        DialogueLine("d7_s_3", "Traveler", "क्या ट्रेन समय पर है?", "Is the train on time?"),
                        DialogueLine("d7_s_4", "Official", "नहीं, आधा घंटा लेट है।", "No, it is half an hour late."),
                        DialogueLine("d7_s_5", "Traveler", "क्या मेरा टिकट कन्फर्म है?", "Is my ticket confirmed?"),
                        DialogueLine("d7_s_6", "Official", "कृपया पीएनआर नंबर बताइए।", "Please tell me the PNR number."),
                        DialogueLine("d7_s_7", "Traveler", "ये लीजिए।", "Here you go."),
                        DialogueLine("d7_s_8", "Official", "हाँ, कोच बी-२, सीट १५।", "Yes—Coach B-2, Seat 15.")
                    ),
                    vocabulary = listOf(
                        VocabItem("d7_v_1", "किस (kis)", "which", "Oblique form used before postpositions: ‘किस प्लेटफॉर्म पर…’."),
                        VocabItem("d7_v_2", "आएगी (aaegii)", "will come/arrive", "Future (f). Many speakers treat ‘ट्रेन’ as feminine: ‘ट्रेन आएगी’."),
                        VocabItem("d7_v_3", "समय (samay)", "time", "More formal/neutral. Colloquial: टाइम. Both are used."),
                        VocabItem("d7_v_4", "पर (par)", "on/at", "Location postposition: ‘प्लेटफॉर्म पर’. Spoken variant: ‘पे’."),
                        VocabItem("d7_v_5", "आधा (aadhaa)", "half", "Used with time: आधा घंटा = half an hour."),
                        VocabItem("d7_v_6", "घंटा (ghanTaa)", "hour", "Also used for duration in speech."),
                        VocabItem("d7_v_7", "लेट (late)", "late", "Common loanword: ‘आधा घंटा लेट है’."),
                        VocabItem("d7_v_8", "सीट (seat)", "seat", "Common loanword for seat number in trains.")
                    ),
                    grammarGuides = listOf(
                        GrammarPoint("Oblique ‘kis’ + postposition", "When ‘which’ is followed by a postposition (पर/में/से), use **किस**:\n\n- ‘किस प्लेटफॉर्म पर?’\n- ‘किस ट्रेन से?’\n\nCommon mistake: ‘कौन पर’ (wrong)."),
                        GrammarPoint("Future + gender agreement (practical)", "In spoken Hindi, some nouns are treated with fixed gender. ‘ट्रेन’ is often treated as feminine:\n\n- ‘ट्रेन **आएगी**।’\n\nBeginner tip: don’t stress too much—focus on being understood, then refine gender agreement gradually."),
                        GrammarPoint("Time status phrases: on time / late", "Useful travel phrases:\n\n- **समय पर** = on time\n- **लेट है** = is late\n- **आधा घंटा लेट** = half an hour late\n\nExample: ‘ट्रेन समय पर है?’ → ‘नहीं, आधा घंटा लेट है।’")
                    )
                ),
                court = CourtSection(
                    title = "The Gita's Karma",
                    poemLines = listOf(
                        "कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।",
                        "मा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥",
                        "Karmaṇy-evādhikāraste mā phaleṣhu kadāchana",
                        "Mā karmaphalaheturbhūrmā te saṅgo'stvakarmaṇi"
                    ),
                    analysis = "Sanskrit Shloka from the Bhagavad Gita (2.47). Krishna speaks to Arjuna.\n\n**The Message:** 'You have a right to perform your prescribed duty (Karma), but you are not entitled to the fruits of action.'\n\n**Nishkama Karma:** Do not let the fruit (result) be the motive for your action. Do not be attached to inaction either. Just do what must be done. This is the central tenet of Dharma.",
                    wordBreakdown = listOf(
                        WordAnalysis("d7_c_1", "कर्मणि (Karmani)", "In action/duty", "Locative case of Karma."),
                        WordAnalysis("d7_c_2", "एव (Eva)", "Only", "Emphasis."),
                        WordAnalysis("d7_c_3", "अधिकार (Adhikara)", "Right/Authority", "Jurisdiction."),
                        WordAnalysis("d7_c_4", "मा (Ma)", "Not", "Prohibition."),
                        WordAnalysis("d7_c_5", "फलेषु (Phaleshu)", "In the fruits/results", "Locative plural of Phala."),
                        WordAnalysis("d7_c_6", "कदाचन (Kadachana)", "Ever/At any time", "Never be attached."),
                        WordAnalysis("d7_c_7", "सङ्गो (Sango)", "Attachment", "Association/Clinging."),
                        WordAnalysis("d7_c_8", "अकर्मणि (Akarmani)", "In inaction", "Not doing duty.")
                    )
                )
            )
        )
    }
}
