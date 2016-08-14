/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamj.arquitectura.hitchus.nosql.persistence;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

/**
 *
 * @author Freddy
 */

public final class PersistenceManager {

    private  static final PersistenceManager INSTANCE = new PersistenceManager();
    private static Morphia morphia;
    private static MongoClient mongoClient;
    private final Datastore mds;
    public static final String DB_NAME = "usuarios";
    public static final String DB_PACKAGE = "com.teamj.arquitectura.hitchus.nosql.model";

    public PersistenceManager() {
        MongoClientOptions mongoOptions
                = MongoClientOptions.builder().socketTimeout(60000).connectTimeout(60000).build();

        try {

            mongoClient = new MongoClient(new ServerAddress("localhost"), mongoOptions);

        } catch (Exception e) {

            throw new RuntimeException("Error", e);
        }

        mongoClient.setWriteConcern(WriteConcern.SAFE);
        morphia = new Morphia();

        morphia.mapPackage(DB_PACKAGE, true);
        mds = morphia.createDatastore(mongoClient, DB_NAME);
        mds.ensureIndexes();
    }

    public Datastore datastore() {
        return this.mds;
    }

    public static PersistenceManager instance() {

        return INSTANCE;

    }
}
