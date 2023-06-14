def transform_natural_language_to_leet_language(text):
    leet_mapper = {"a": "4", "b": "I3", "c": "[", "d": ")", "e": "3", "f": "|=", "g": "&", "h": "#", "i": "1",
                   "j": ",_|", "k": ">|", "l": "1", "m": "/\/\\", "n": " ^/", "o": "0", "p": " |*", "q": "(_,)",
                   "r": "I2", "s": "5", "t": "7", "u": "(_)", "v": "\/", "w": "\/\/", "x": "><", "y": "j", "z": "2"}
    leet_text = ""

    for word in text:
        if word.lower() in leet_mapper.keys():
            leet_text += leet_mapper[word.lower()]
        else:
            leet_text += word

    return leet_text


print(transform_natural_language_to_leet_language('this is a test language'))
