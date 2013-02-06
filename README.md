What is Frames-Titan Plugin ?
============

**Frames-Titan plugin** is a Java O/G mapper for the [Titan](https://github.com/thinkaurelius/titan/wiki/Getting-Started) with  the [Play! framework](http://www.playframework.org/) 2. It is used with the [TinkerPop Frames](https://github.com/tinkerpop/frames/wiki) for O/G mapping.

Features
======

* Object-Graph-Mapping by the [TinkerPop Frames](https://github.com/tinkerpop/frames/wiki)

Requirements
=========

* Java 5 or 6
* Play2.1.0

Install
====

  1)  Install Play framework 2.1.0

  2)  Executing the command for installing the [Frames Module](https://github.com/sgougi/play21-frames-module) 

         % git git@github.com:sgougi/play21-frames-module.git
  
  3)  Publishing the Frames Module to your local repository
           
         % cd play21-frames-module
         % play publish-local

  4)  Executing the command for installing the Frames-Titan Plugin

         % git git@github.com:sgougi/play21-frames-titan-plugin.git
         
  5)  Publishing the Frames-Titan Plugin to your local repository

         % cd play21-frames-titan-plugin
         % play publish-local


Run sample application and Usage
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

## Extended Annotatins 

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

####[@IndexedProperty](https://github.com/sgougi/play21-frames-module/blob/master/app/com/wingnest/play2/frames/annotations/IndexedProperty.java)
Defines one or more attributes as indexed attribute.(Titan currently does not support the [IndexableGraph](https://github.com/tinkerpop/blueprints/wiki/Graph-Indices))

 ex:

       public interface A {
         ...
         @IndexedProperty("type")
          public String getType();
         @IndexedProperty("type")
          public void setType(String type);
         ...
       }

       Index<Vertex> index = GraphDB.getIndex(A.class.getSimpleName(), Vertex.class);
       Iterable<Vertex> types = index.get("type", "text");

### For Controllers
####[@WithGraphDB](https://github.com/sgougi/play21-frames-module/blob/master/app/com/wingnest/play2/frames/annotations/WithGraphDB.java)
The **@WithGraphDB** annotation enables annotated Actions and/or Controllers to use **Titan** implicitly.

Known Issues
=============
* Nothing

Licence
========
Frames-Titan Plugin is distributed under the [Apache 2 licence](http://www.apache.org/licenses/LICENSE-2.0.html).
