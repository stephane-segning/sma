import {PropsWithChildren, useMemo} from "react";
import {CourseApi, StaffApi, StudentApi} from "@rtb";
import {apiContext} from "./context.tsx";

const DEFAULT_BASE_PATH = 'http://localhost:8080';

interface ApiContextProviderProps {
    basePath?: string;
}

export function ApiContextProvider({children, basePath: b}: PropsWithChildren<ApiContextProviderProps>) {
    const basePath = b ?? DEFAULT_BASE_PATH;

    const value = useMemo(() => {
        const staff = new StaffApi(undefined, basePath);
        const student = new StudentApi(undefined, basePath);
        const course = new CourseApi(undefined, basePath);
        return ({
            staff,
            student,
            course
        });
    }, [basePath]);

    return (
        <apiContext.Provider value={value}>
            {children}
        </apiContext.Provider>
    )
}