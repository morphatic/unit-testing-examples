# Unit Testing Examples

This repository has examples of unit testing in seven different programming languages (using the testing libraries in parentheses):

* Go (built-in testing library)
* Java (JUnit)
* JavaScript (Jest)
* PHP (PHPUnit)
* Python (Pytest)
* R (testthat)
* Ruby (Minitest)

There are two examples per programming language.

## Sums

In the `sums` folder, each of the programs has a single function called `sum(a, b)` (in R it's called `my_sum()` because R already has a built-in function called `sum()`) that can take two numeric parameters. The function is supposed to return, surprisingly, the sum of the two numbers.

These examples are designed to be the "Hello, World!" of unit testing, i.e. the simplest possible testing example that could work to illustrate the basic principle. All of them are designed to be executed from the command line. There is [an online slide deck that accompanies these examples](https://slides.com/morphatic/test-driven-development) that has a screenshot of the tests being run from the command line.

Most of the examples require the developer to do some basic (or not so basic) configuration of the dev environment. Below are notes for each different language as to what is generally necessary to get these examples running on your system.

## Get Titles

In the `getTitle` folder, each program contains a single exported function, or a class that contains a function, called `getTitle(url)`. This function takes a string parameter that is a URL and (assuming the target URL points to an HTML page) returns the contents of the `<title>` tag on the target page. There is no attempt at error handling or dealing with situations when the target URL points to something other than an HTML page.

The primary goal of these examples is to show an example of code that relies on one or more 3rd party libraries. In particular, these programs rely on libraries for making HTTP requests and also for using regular expressions to parse the contents of a string. A key principle in unit testing is **ONLY TEST YOUR OWN CODE**. It is not our responsibility to test the 3rd party library code. Therefore, each of these example unit tests uses some sort of mock or stub to fake the HTTP request. It should be possible to run all of the tests without an internet connection.

## Caveat and Disclaimer

I am NOT an expert in all of these languages. I fully realize that some of these examples violate "best practices" in terms of the approach/architecture/paradigm for that language, and perhaps programming in general. I have somewhat sacrificed best practices in order to make all of the examples do roughly the same thing. If you have a suggestion of a better way to do things, please create an issue or submit a pull request with your recommended changes. These are designed to be a learning tool, and also a quick reminder for myself when I need to remember how to set up a testing environment in one of these languages.

Also, the language-specific notes below are not intended to be a comprehensive guide to getting these programming languages running on your system. You should expect to still have to do a fair amount of googling to figure out how to make these things work. Consider what I've written below to be "hints."

## Language-specific Notes

Below are some notes for each of the programming languages as to how to get these samples up and running. For Windows users, I strongly encourage you to use the Git Bash terminal that comes packaged with [Git](https://git-scm.com). This allows you to use linux-like commands instead of the Windows versions.

### Go

[Install Go](https://golang.org/). In general, to build the programs, navigate to the `go` directory from the command line and type `go build`. To run the tests type `go test`. For the `getTitle()` program you'll probably have to install a 3rd party library (`httpmock`) by typing `go get gopkg.in/jarcoal/httpmock.v1` at the command line. That will download the library to a place where go can find it.

### Java

[Install the JDK](http://www.oracle.com/technetwork/java/javase/downloads/index.html). In order to run the JUnit tests, you'll have to [download two .jar files (`junit.jar` and `hamcrest-core.jar`), and save them to your classpath for your tests](https://github.com/junit-team/junit4/wiki/Download-and-Install). Don't know what a "classpath" is? Figuring this out is part of the fun of learning to program with Java. 😎 In order to run the `getTitle()` tests, you'll have to [download the Google HTTP Client library for Java](https://developers.google.com/api-client-library/java/google-http-java-client/download), unzip it and store the `.jar` files in your classpath. To run the tests, if you put all the `.jar` files in your classpath, you can just `cd` to the java directory and type:

```
javac *.java
java org.junit.runner.JUnitCore ArithmeticTests
```

This should compile the classes and run the tests. If you didn't figure out the classpath thing, you can try something like:

```
javac *.java
java -cp .:/path/to/your/jar/files org.junit.runner.JUnitCore ArithmeticTests
```

That's a way of setting your classpath on the fly. You still have to know where they're stored on your system.

### JavaScript

[Install NodeJS](https://nodejs.org). It doesn't matter whether you choose the LTS version or the bleeding edge version. Both should work. `cd` into the `js` folder and type `npm install` to download the necessary additional files to run the tests. Then type `npm test`. That should be it!

### PHP

Google "how to install PHP on [your operating system]" and follow the easiest instructions you can find. PHP may already be installed if you have a Mac. You'll also probably want to find a tutorial to show you how to install [PHPUnit](https://phpunit.de/index.html) on your system as well. Make sure you get the version of PHPUnit that matches the version of PHP that you have. Assuming you get both of these installed and can run them from the command line, to run the tests type `phpunit [name of file to be tested]`, e.g. `phpunit test_sum.php`. Getting PHP and PHPUnit may be a little bit trickier than for other languages, but running the tests is that easy.

### Python

[Install Python](https://www.python.org/). If it's not already installed on your system, you should install version 3.x. With any luck, this will also install `pip`, a package manager for Python. If you don't have `pip`, then figure out how to install it. Next you'll have to [install `pytest`](https://docs.pytest.org/en/latest/getting-started.html) which hopefully will be as simple as typing `pip install -U pytest`. Once `pytest` is installed, running the tests is as easy as navigating to the `python` directory and typing `py.test` at the command line.

### R

[Download and install R](https://cloud.r-project.org/). Once you've done that, from the command line type `R` to start an interactive `R` session. Install necessary packages by typing the following commands:

```
install.packages("httr")
install.packages("stringr")
install.packages("testthat")
install.packages("httptest")
install.packages("xml2")
```

Type `q()` to quit the interactive session. At this point you should be able to navigate to one of the `r` directories in this project and type `Rscript run_tests.R`. This should run the tests for that program.

### Ruby

[Download and install Ruby](https://www.ruby-lang.org). This should set up both the `ruby` and the `gem` commands. You'll need to install two additional gems (the Ruby name for "libraries" is "gems") manually. To do this type `gem install http` and `gem install webmock`. You should probably navigate to the `ruby` directory in this project before installing the gems, although it might install them globally if you're lucky. After the necessary gems are installed, you can navigate to a `ruby` folder (if you're not already there) and type `ruby xxx.spec.rb` where `xxx` is the name of the `spec` file in that directory. That's all there is to it.

## License

All of the code in this repository is released under an MIT license. You are whole-heartedly encouraged to take this code and do with it whatever you would like. I hope it is useful in some degree.