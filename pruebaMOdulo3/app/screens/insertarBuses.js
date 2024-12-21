import { StyleSheet, Text, View, FlatList, TouchableHighlight, TextInput, Alert } from 'react-native';
import { useState } from 'react';
import { FAB } from '@rneui/themed';
import { Input, Button } from '@rneui/base'
import { servicioCrearBus } from './services/TestServices'

export const BusesScreen = () => {
    const [bus, setBus] = useState();
    const [capacidad, setCapacidad] = useState();

    const createService = () => {
        servicioCrearBus({
            idBUS: bus,
            capMax: capacidad
        },
            () => {
                Alert.alert("CONFIRMACIÓN", "SE HA INGRESADO EL NUEVO POST")
            });
    }

    return <View StyleSheet={styles.container}>
        <View style={styles.container}></View>
        <Input
            value={bus}
            onChangeText={(value) => {
                setBus(value)
            }}
            placeholder='Codigo Bus'
            label='Bus'
        />
        <Input
            value={capacidad}
            onChangeText={(value) => {
                setCapacidad(value)
            }}
            placeholder='Max Pasajeros'
            label='Bus'
            keyboardType='numeric'
        />
        <Button title='Enviar'
            onPress={createService}
        />

    </View>

}


const styles = StyleSheet.create({
    container: {
        flex: 1,
        flexDirection: 'column',
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    Input: {
        height: 40,
        margin: 12,
        borderWidth: 1,
        padding: 10,
        borderRadius: 20,
    }
});