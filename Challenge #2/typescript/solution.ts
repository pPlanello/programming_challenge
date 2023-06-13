
const mapper: object = {
  a: "4",
  b: "l3",
  c: "[",
  d: ")",
  e: "3",
  f: "|=",
  g: "&",
  h: "#",
  i: "1",
  j: ",_l",
  k: ">|",
  l: "1",
  m: "/\\/\\",
  n: "^/",
  o: "0",
  p: "|*",
  q: "(_,)",
  r: "l2",
  s: "5",
  t: "7",
  u: "|_|",
  v: "\/",
  w: "\/\/",
  x: "><",
  y: "`/",
  z: "2"
}

const transformNaturalLanguageToLeetLanguage = (text: string): void => {
  let leetText: string[] = []

  text.split('').map((word: string) => {
    const leetWord = mapper[word]
    if (leetWord === undefined) {
      leetText.push(' ')
    }
    leetText.push(leetWord)
  })

  console.log(leetText.join(''))
}

transformNaturalLanguageToLeetLanguage('This is a test language')


