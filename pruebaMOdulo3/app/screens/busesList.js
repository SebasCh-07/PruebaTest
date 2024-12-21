import React from 'react';
import { View, FlatList, StyleSheet, Text, StatusBar } from 'react-native';

const DATA = [
    {
        codigo: "B01",
        max_personas: 38
    },
    {
        codigo: "B02",
        max_personas: 38
    }

];

export const BusesLista = () => (
    <View style={styles.areaTitulo}>
        <Text style={styles.titulo}>BUSES</Text>
        <FlatList
            data={DATA}
        />
    </View>
);

const styles = StyleSheet.create({
    container: {
      flex: 1,
      backgroundColor: '#fff',
      flexDirection: "column",
      alignItems: 'center',
      justifyContent: 'center',
      padding: 20
    },
    areaBotones: {
      flex: 2,
      flexDirection: 'row',
      marginBottom: 10,
      justifyContent: 'center',
      alignItems: 'flex-start',
     // backgroundColor: "#ecfcd0",
    },
    titulo: {
      fontSize: 20,
      fontWeight: 'bold',
    },
    areaTitulo: {
      flex: 1,
      margin: 10,
      justifyContent: 'flex-end',
      alignItems: "center",
      //backgroundColor: "skyblue"
    },
    boton: {
      backgroundColor: '#4CAF50',
      padding: 10, 
      margin: 10,
      borderRadius: 5, 
    },
    textoBoton: {
      color: 'white', 
      textAlign: 'center',
      fontSize: 16,
    }
  });

