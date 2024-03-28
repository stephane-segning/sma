import {apiContext} from "./context.tsx";
import {useContext} from "react";

export function useStaff() {
    return useContext(apiContext).staff;
}

export function useStudent() {
    return useContext(apiContext).student;
}

export function useCourse() {
    return useContext(apiContext).course;
}
