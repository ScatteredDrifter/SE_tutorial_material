# Lesson 00:

This session was primarily focusing on:
- getting to know _the terminal_ (CLI)
- understanding the core principle of **git** 
- how to use basic **git** 

---

## Getting familiar with the terminal ( bash specifically ):

### Motivation:

Im Laufe der Vorlesung werden wir uns immer wieder im _Terminal_ ( etwa Git bash, dem Terminal eurer IDE, also etwa von VSCode oder IntellIJ ) befinden und müssen uns deswegen **grundlegend zurechtfinden können**.
Das heißt, dass wir folgend Dateien **Erstellen**, **Verschieben**, **Bearbeiten** können und uns auch in den Orndern zurechtfinden, also etwa Wissen **wie wir relativ zum derzeitigen Punkt** weiter in einen Ordner kommen oder aus ihm heraus gehen können.

### Basic Commands:
Below I will list some basic commands that are fundamental to navigate the terminal and work with it. 

>[!important] 
> Pressing **TAB** (Tabulator Taste) can suggest you the next step to take in a command. 
> For example we can get a list of all available files in the current directory if we write `cd **press tab twice**` or autocomplete a path we began writing, such as `cd Dow**Tab twice** --> cd Downloads/`

### Navigating: 

The terminal usually indicates at which position ( in the directory structure ) you are at. This is denoted by the prefix that shows before the field where you can **type something**. 

**the position is usually relative**, so whenever we are in a folder we can navigate to everyting contained in it easier. This also means that reaching a folder **outside of the current position** needs to either be addressed **relatively to the current position** or **absolute from the _root_ of the file structure**.

I think giving an example may help here a little more:
Consider the following base structure of a filesystem:
```
Everything below is contained in the folder "SE_tutorial_material":
.
├── README.md
├── sessions
│   └── lesson00
│       ├── README.md
│       ├── terminal_test
│       │   ├── aufgabe
│       │   │   └── hallo.md
│       │   ├── downloads
│       │   │   ├── uebung00.md
│       │   │   └── uebung01.md
│       │   └── material
│       │       └── infoscmd.txt
│       ├── test_repo
│       │   ├── tessting4
│       │   ├── test33
│       │   ├── test_file.txt
│       │   ├── testfile.txt
│       │   ├── testing_this_structure.py
│       │   ├── vimgitnano
│       │   └── yetanother
│       └── understandinGit
│           ├── Datei__0.txt
│           ├── Datei__1.txt
│           ├── test_file.txt
│           └── uebungsaufgabe00.py
└── slides
    └── 191.06_lesson00.md

```

Now this is plenty but consider we are located at the top, **so we are currently in "SE_tutorial_material"**:

If we wanted to reach and look at 191.06_lesson00.md what we would do is the following:
`cat slides/191.06_lesson00.md` "cat" is displaying the content of the file we selected, just to show it ^^.

What if we moved into "test_repo" and wanted to display the same slide again? 
To do that we are entering the follwing:

```
cd sessions/lesson00/test_repo 
-> we are entering the folder relative to our current position

ls ../
-> this shows the structure of the folder "one step back", my output:
[evelyn@Scattered-Are15 test_repo]$ ls ../
README.md  terminal_test  test_repo  understandinGit


cat ../../../slides/191.06_lesson00.md 
-> we are using "../" to navigate "one step back" 
and this 3 times because we went into 3 folders (in comparison to our starting point)
and then navigate ( we only look! not move ) _into the folder_ "slides" once more
```

### Root what?:
Now this gave us a short idea on how to navigate **relatively**. 

If we want to travel / navigate **absolute** we always need a **reference point** that denotes _start of our filesystem_.
This means that at this point everything else is "contained in it". 
Because of this idea we also call this **root** ( and its denoted with "/" in linux for example). 

If you're still contained within the folder "test_repo" we can take a look and see its "absolute path from root":
For that we can use:
`pwd` | my output:
```
evelyn@Scattered-Are15 test_repo]$ pwd
/home/evelyn/tech-cluster/Programming/course_software_engineering/SE_tutorial_material/sessions/lesson00/test_repo
```
So yea this folder is deep within my filesystem ^^. 

### Home?:

There's another cool idea that we can use to navigate the terminal.
Remember how we used "the root" as **absolute reference point** before? Well always going from "the root" of the whole filesystem is tedious and somewhat annoying. 
So what, if we could navigate "the root" in "reference of our active user"?

This means that the _new root_ is now denoted by the _folder_ where all files that belong to me are contained in. 

**To use this position as reference for navigating files** we can use the following prefix to our paths:
` ~/`
So instead of the following, we can shorten the path further: 
```
before:
/home/evelyn/tech-cluster/Programming/course_software_engineering/SE_tutorial_material/sessions/lesson00/test_repo
after:
~/tech-cluster/Programming/course_software_engineering/SE_tutorial_material/sessions/lesson00/test_repo
```

Well in this case this did not change much but it can be useful because we have a point to start from we know.

## Moving basics: 

We've now seen things like "../" that help us navigate "backwards". 
Another cool thing to use ( for example for `tree .` ) is ".". This dot means that we want to "use the command on the current directory". 
So if i was in test_repo again "ls ." would show me all files contained in it!

Before we've already seen commands like "cd" or "ls" etc. Below I'll give a short list
that contains basic terminal commands that one might find useful. In this list anything with **[something stands here]** means that we can add _an option_ so for example a path, a filename or smth similar:

ls -> show current directory and whats contained in it 
ls [pathToDirectory] -> shows the content of the given path

cd -> without anything cd will bring you to your "HOME" --> so the _personal reference point_
cd [pathToDirectory] -> will bring you to the denoted path ( remember you can use the tricks like ../../ ... to navigate "backwards" and more

cp [originalFile] [targetPathForFile] -> copys the originalFile to the targetPathForFile 
mv [originalFile] [targetPathForFile] -> _moves_ the originalFile to the targetPathForFile
rm [originalFile] -> deletes originalFile 
rm -R [pathToDirectory] -> **deletes the whole directory** ( attention here!)

tree -> (this ones only available on linux and macOs afaik ) displays a visual representation of the given path

touch [pathToFile] -> creates a new _empty_ file at the given path. Examples would be "touch readme.md" or touch Downloads/testfile.md"

mkdir [pathToDirectory] creates a directory at the given path.

nano [pathToFile] -> opens nano " a file editor within the terminal" to allow editing it.

