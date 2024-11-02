## Proyecto 1 - Programación I

The goal of this project was to implement a **catalog program for items** in Java, which can be used  **through a CLI** (command-line interface).

Specifically, this catalog has been made for **clothing items**.

## Usage

First, **compile** the program with the command :

```
make
```

Then, **launch** the generated executable with the following command :

```
./a.out
```

> You can also generate and run a ```.jar``` file directly instead, with the command ```make runjar```.
> You can find other available Makefile commands [here](/docs/make.md)

<br>

This will automatically launch the **CLI**. Here's how to use it :

```
./a.out
Products loaded successfully

> <OPTION>

OPTIONS:
    add product     : create and add a product (asks for item type, color, size...etc)
    list            : list all the products
    exit            : exit the CLI
```

## Data Persistence

The program uses object persistence using Java's ```ObjectOutputStream```and ```ObjectInputStream```, automatically saving created products to a file (_"data.dat"_) when exiting. It also loads data from (_"data.dat"_) file if it exists upon launch.

## UML Diagram

<br>

<p align="center">
  <img src="http://www.plantuml.com/plantuml/proxy?src=https://raw.githubusercontent.com/khalidCEU/proyecto1/refs/heads/main/docs/diagram.puml" alt="Class Diagram" width=40%>
</p>

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE](/LICENSE) file for details.
