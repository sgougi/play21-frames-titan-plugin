What is Frames-Titan Plugin ?
============

**Frames-Titan plugin** is a Java O/G mapper for the [Titan](https://github.com/thinkaurelius/titan/wiki/Getting-Started) with  the [Play! framework](http://www.playframework.org/) 2. It is used with the [TinkerPop Frames](https://github.com/tinkerpop/frames/wiki) for O/G mapping.

Features
======

* Object-Graph-Mapping by the [TinkerPop Frames](https://github.com/tinkerpop/frames/wiki)

* Support for auto-reloading

Requirements
=========

* Java 5, 6 or 7
* Play 2.2.1

Dependencies
============

* Titan 0.4.2
* TinkerPop BluePrints 2.4.0
* TinkerPop Frames 2.4.0

Setup
====

  1)  Installing Play framework 2.2

  2)  Executing the command for installing the [TinkerPop Frames Module](http://goo.gl/0g43T) 

         % git clone git@github.com:sgougi/play21-frames-module.git
         % cd play21-frames-module
         % git checkout 2.4.4
  
  3)  Publishing the Frames Module to your local repository
           
         % cd play21-frames-module
         % play publish-local

  4)  Executing the command for installing the Frames-Titan Plugin

         % git clone git@github.com:sgougi/play21-frames-titan-plugin.git
         
  5)  Publishing the Frames-Titan Plugin to your local repository

         % cd play21-frames-titan-plugin
         % play publish-local


Running a sample application and Usage
=======================

At a command prompt, type the following commands:

         % cd play21-frames-titan-plugin
         % cd samples
         % cd frames-simple-app
         % play run

There are basic usage in the source code of a [sample application](samples). 

* [Annotated model classes](samples/frames-simple-app/app/models)
* [Creating a key index](samples/frames-simple-app/app/Global.java)
* [Application configuration: conf/application.conf](samples/frames-simple-app/conf/application.conf)
* [Dependency settings: project/Build.scala](samples/frames-simple-app/project/Build.scala)  
* [Controller with transaction](samples/frames-simple-app/app/controllers/Application.java)

## Facade Class for GraphDB

The com.wingnest.play2.frames.[GraphDB](https://github.com/sgougi/play21-frames-module/blob/master/app/com/wingnest/play2/frames/GraphDB.java) class is a Facade class.

* GraphDB.commit()
* GraphDB.rollback()
* GraphDB.getGraph()
* GraphDB.createFramedGraph()
* GraphDB.getGraphManager()
* GraphDB.createKeyIndex()
* GraphDB.dropKeyIndex()
* GraphDB.createIndex()
* GraphDB.dropIndex()
* GraphDB.getIndexedKeys()
* GraphDB.getIndex()
* GraphDB.getIndices()

## Extended Annotations 

### For Models
####[@Id](https://github.com/sgougi/play21-frames-module/blob/master/app/com/wingnest/play2/frames/annotations/Id.java)
Defines one attribute as id attribute.

 ex:

       public interface A {
         ...
         @Id
         public Object getId();
         ...
      }


### For Controllers
####[@WithGraphDB](https://github.com/sgougi/play21-frames-module/blob/master/app/com/wingnest/play2/frames/annotations/WithGraphDB.java)
The **@WithGraphDB** annotation enables annotated Actions and/or Controllers to use **Titan** implicitly.

Known Issues
=============
* Nothing

Licence
========
Frames-Titan Plugin is distributed under the [Apache 2 licence](http://www.apache.org/licenses/LICENSE-2.0.html).
